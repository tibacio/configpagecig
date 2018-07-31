<%-- 
    Document   : importLeads
    Created on : 2018-7-20, 0:31:50
    Author     : baci
--%>

<%@page import="bean.Leads"%>
<%@page import="com.univocity.parsers.csv.CsvWriter"%>
<%@page import="com.univocity.parsers.common.processor.BeanWriterProcessor"%>
<%@page import="com.univocity.parsers.csv.CsvWriterSettings"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="org.apache.commons.lang3.math.NumberUtils"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
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

<%@ page contentType="text/html;charset=utf-8" language="java" %>\
<%@page pageEncoding="utf-8" %>
<%
    String st = request.getParameter("st");
    String rsd = request.getParameter("rsd");
    String y = request.getParameter("y");

    String sdate;
    String edate = y;

    if (StringUtils.isBlank(st)) {
        sdate = y + "-01-01";
        edate = (NumberUtils.toInt(y) + 1) + "-01-01";
    } else {
        sdate = y + "-" + new DecimalFormat("00").format(NumberUtils.toInt(st)) + "-01";
        edate = y + "-" + new DecimalFormat("00").format(NumberUtils.toInt(st) + 1) + "-01";
    }

    WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
    JdbcTemplate jt = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
    SqlRowSet rs = jt.queryForRowSet("select allleads.MOBILE, allleads.CUSTOMER_NAME, "
            + "allleads.ID, allleads.LEAD_TYPE,  "
            + "allleads.ORDER_TIME, allleads.CREATE_TIME, allleads.STATUS,  "
            + "allleads.DELETE_FLAG, allleads.SERIES, allleads.SYNC_STATUS,  "
            + "allleads.SYNC_TIME, allleads.CRM_SYNC_STATUS,  "
            + "allleads.CRM_IS_VALID, allleads.CRM_IS_SENT, allleads.IS_REPEATER, "
            + "allleads.catetype, allleads.HighLvlChannelName, allleads.media,"
            + "allleads.channeltype, allleads.media, allleads.DEALER_NAME, "
            + "allleads.DEALER_CODE, newdealershd.rsd, newdealershd.sd , allleads.SERIES_NAME, allleads.CITY_NAME  "
            + "from allleads, newdealershd  "
            + "where allleads.DEALER_CODE= newdealershd.dcode  and allleads.CREATE_TIME between  ?  and ? and dbo.newdealershd.rsd=? ", sdate, edate, rsd);

        response.setContentType("application/csv;charset=GB2312");
    response.setHeader("Content-Disposition", "attachment;filename="+rsd+"_"+y+"_"+st+".csv");
    
    CsvWriterSettings cws = new CsvWriterSettings();
    cws.setHeaderWritingEnabled(true);
    cws.setRowWriterProcessor(new BeanWriterProcessor(Leads.class));
    CsvWriter writer = new CsvWriter(response.getWriter(), cws);    

    int rows=0;
    
    while (rs.next()) {
        Leads l=new Leads();
        l.setCatename(rs.getString("catetype"));
        l.setChannel(rs.getString("HighLvlChannelName"));
        l.setCtime(rs.getString("CREATE_TIME"));
        l.setDcode(rs.getString("DEALER_CODE"));
        l.setDname(rs.getString("DEALER_NAME"));
        l.setHiname(rs.getString("HighLvlChannelName"));
        l.setMedia(rs.getString("media"));
        l.setRsd(rs.getString("rsd"));
        l.setSd(rs.getString("sd"));
        l.setSeries(rs.getString("SERIES_NAME"));
        l.setCname(rs.getString("CUSTOMER_NAME"));
        l.setMobile(rs.getString("MOBILE"));
        
        writer.processRecord(l);
        
        if(rows%100==0)
            writer.flush();
    }


%>



