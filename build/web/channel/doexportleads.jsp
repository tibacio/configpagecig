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


    WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
    JdbcTemplate jt = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
    
    String rsd=request.getParameter("rsd");
    String st=request.getParameter("st");
    String et=request.getParameter("et");
    
    
    
    SqlRowSet rs = jt.queryForRowSet("SELECT MOBILE, CUSTOMER_NAME, ID, FK_DEALER_ID, LEAD_TYPE, ORDER_TIME, CITY, PROVINCE, CREATE_TIME, STATUS, DELETE_FLAG, SERIES, catekey, HighLvlChannel, channelkey, mediakey, catetype, HighLvlChannelName, channeltype, media, DEALER_NAME, DEALER_CODE, LARGER_REGION_CODE, SERIES_NAME, PROVINCE_NAME, CITY_NAME "+
        "FROM DDMPWebService.dbo.allleads where CREATE_TIME between ? and ?  and LARGER_REGION_CODE=?",st,et,rsd );

      while(rs.next()){
          
      }
    

%>



<%!
    
    
    CsvWriterSettings cws= new CsvWriterSettings();
    cws.setHeaderWritingEnabled(true);
    cws.setRowWriterProcessor(new BeanWriterProcessor(Dealer.class));
    CsvWriter writer = new CsvWriter(response.getWriter(),cws );
    
    response.setContentType("application/csv;charset=GB2312");
    response.setHeader("Content-Disposition", "attachment;filename=dealer.csv");
    
    while(rs.next()){
       Dealer d=new Dealer();
       d.setId(rs.getString("DEALER_ID"));
       d.setName(rs.getString("DEALER_NAME"));
       d.setCode(rs.getString("DEALER_CODE"));
       d.setCity(rs.getString("FK_CITY_ID"));
       d.setCname(rs.getString("CITY_NAME"));
       d.setProvince(rs.getString("FK_PROVINCE_ID"));
       d.setPname(rs.getString("PROVINCE_NAME"));
       d.setRsd(rs.getString("LARGER_REGION_CODE"));
       
       writer.processRecord(d);
    }
    
    writer.close();
%>
