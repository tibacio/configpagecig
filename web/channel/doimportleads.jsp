<%-- 
    Document   : importLeads
    Created on : 2018-7-20, 0:31:50
    Author     : baci
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.jdbc.support.rowset.SqlRowSet"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.jdbc.core.JdbcTemplate"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.commons.lang3.time.DateFormatUtils"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.apache.commons.lang3.RandomStringUtils"%>
<%@page import="org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.LineNumberReader"%>
<%@page import="java.io.StringReader"%>
<%@page import="soa.BaseInfoService"%>
<%@page import="bean.SendLeadRecord"%>
<%@page import="java.util.List"%>
<%@page import="com.univocity.parsers.common.processor.BeanListProcessor"%>
<%@page import="com.univocity.parsers.csv.CsvParserSettings"%>
<%@page import="com.univocity.parsers.csv.CsvParser"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.Reader"%>
<%@page import="java.io.InputStream"%>

<%@ page contentType="text/html;charset=gb2312" language="java" %>\
<%@page pageEncoding="gb2312" %>
<%

    HashMap hm = new HashMap();
    hm.put("宝来", "10");
    hm.put("捷达", "13");
    hm.put("CC", "15");
    hm.put("高尔夫", "16");
    hm.put("新速腾", "20");
    hm.put("全新宝来", "21");
    hm.put("高尔夫R-Line", "22");
    hm.put("高尔夫嘉旅", "23");
    hm.put("全新一代迈腾", "24");
    hm.put("新速腾GLI", "25");
    hm.put("新速腾R-Line", "26");
    hm.put("蔚领", "27");
    hm.put("新捷达", "28");
    hm.put("探歌", "29");
    hm.put("全新一代宝来", "30");
    hm.put("GTI", "7");
    hm.put("迈腾", "8");
    hm.put("速腾（领先型、精英型）", "9");

    WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
    JdbcTemplate jt = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

    ServletFileUpload upload = new ServletFileUpload();

    BaseInfoService bis = new BaseInfoService();

    InputStream is = upload.getItemIterator(request).next().openStream();
    InputStreamReader r = new InputStreamReader(is);

    CsvParserSettings settings = new CsvParserSettings();

    BeanListProcessor rowProcessor = new BeanListProcessor(SendLeadRecord.class);

    settings.setProcessor(rowProcessor);
    settings.setHeaderExtractionEnabled(true);

    CsvParser parser = new CsvParser(settings);
    parser.parse(r);
    List<SendLeadRecord> l = rowProcessor.getBeans();

    StringBuilder ip = new StringBuilder();
    int i = 1;
    PrintWriter pw = response.getWriter();
    String result = "";
    for (SendLeadRecord slr : l) {
        String mkey = getMediaKey(jt, slr.getMedia().replaceAll(" ", "").replaceAll("\t", "").replaceAll("　", ""));
        String ckey = getLeadtype(jt, slr.getCatetype().replaceAll(" ", "").replaceAll("\t", "").replaceAll("　", ""),
                slr.getHiname().replaceAll(" ", "").replaceAll("\t", "").replaceAll("　", ""),
                slr.getLowname().replaceAll(" ", "").replaceAll("\t", "").replaceAll("　", ""),
                slr.getMedia().replaceAll(" ", "").replaceAll("\t", "").replaceAll("　", ""));
        Dealer d = getDealer(jt, slr.getDealercode());
        ip.append("{'Key':'").append(mkey).append("','RequestObjectList':"
                + "[{'USER_KEY':'").append(mkey).append("','LEAD_TYPE':'").append(ckey)
                .append("','SMART_CODE':'").append(getSmartCode(jt, ckey)).append("','MEDIA_LEAD_ID':'").append(mkey + "_" + RandomStringUtils.random(11, "ABCDEF0123456789")).append("',"
                + "'CUSTOMER_NAME':'").append(slr.getName()).append("','GENDER':'1','MOBILE':'").append(slr.getMobile().replaceAll(" ", "").replaceAll("\t", "").replaceAll("　", "")).append("',"
                + "'EMAIL':'','BUY_PLAN_TIME_CODE':'0','PROVINCE':'").append(d.pid).append("','CITY':'").append(d.cid).append("',"
                + "'FK_DEALER_ID':'").append(d.did).append("','SERIES':'").append(hm.get(slr.getSeries().replaceAll(" ", "").replaceAll("\t", "").replaceAll("　", ""))).append("','MODEL':'',"
                + "'ORDER_TIME':'").append(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss")).append("','PHONE':'','BUSINESS_PHONE':'',"
                + "'ADDRESS':'','CONTACT_METHOD':'','FAX':'','BIRTHDAY':'','PROFESSION':'',"
                + "'INDUSTRY':'','CAR_COLOR':'','COMMENTS':''}]}");
        result = bis.getBasicHttpBindingIBaseInfoService().sendLeads(ip.toString());
        i++;
        pw.println("第" + i + "行： " + result+"<br/>");
        pw.flush();
        ip.setLength(0);
        java.lang.Thread.sleep(1000);
    }
    pw.flush();
    pw.close();
%>



<%!
    public String getLeadtype(JdbcTemplate jt, String cactname, String hiname, String lowname, String sourcename) {
        SqlRowSet rs = jt.queryForRowSet("SELECT ChannelKey  FROM DDMPWebService.dbo.viewChannelKeyShd where  ContactTypeName=? "
                + "and HighLvlChannelName=? and  LowLvlChannelName=? and  SOURCEDetailName=?", cactname, hiname, lowname, sourcename);
        rs.first();
        return rs.getString("ChannelKey");
    }

    public String getMediaKey(JdbcTemplate jt, String mname) {
        SqlRowSet rs = jt.queryForRowSet("SELECT MEDIA_KEY FROM DDMPWebService.dbo.MGR_MEDIAINFO where IS_MEDIA =0  and MEDIA_NAME=? ", mname);
        rs.first();
        return rs.getString("MEDIA_KEY");
    }

    public String getSmartCode(JdbcTemplate jt, String ckey) {
 
        SqlRowSet rs = jt.queryForRowSet("SELECT SMART_CODE FROM DDMPWebService.dbo.SMART_CODE where CHANNEL_KEY=? ", ckey);
        rs.first();
        return rs.getString("SMART_CODE");
    }

    public Dealer getDealer(JdbcTemplate jt, String scode) {
        SqlRowSet rs = jt.queryForRowSet("SELECT  FK_CITY_ID, FK_PROVINCE_ID, DEALER_ID FROM viewDealerRegion where DEALER_CODE=?", scode);
        rs.first();
        Dealer d = new Dealer();
        d.cid = rs.getString("FK_CITY_ID");
        d.pid = rs.getString("FK_PROVINCE_ID");
        d.did = rs.getString("DEALER_ID");
        return d;
    }

    class Dealer {

        String did;
        String pid;
        String cid;
    }
%>
