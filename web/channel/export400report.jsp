
<%@page import="bean.ReportCount"%>
<%@page import="com.univocity.parsers.csv.CsvWriter"%>
<%@page import="com.univocity.parsers.common.processor.BeanWriterProcessor"%>
<%@page import="bean.Dealer"%>
<%@page import="com.univocity.parsers.csv.CsvWriterSettings"%>
<%@page import="org.springframework.jdbc.support.rowset.SqlRowSet"%>
<%@page import="org.springframework.jdbc.core.JdbcTemplate"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page contentType="text/html;charset=GB2312" language="java" %>\
<%@page pageEncoding="GB2312" %>

<%

    WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
    JdbcTemplate jt = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
    SqlRowSet rs = jt.queryForRowSet("SELECT  USER_KEY media, datepart(week,RPT_CALLCENTER_LOG_HISTORY.CREATE_TIME) week,day( RPT_CALLCENTER_LOG_HISTORY.create_time) day,YEAR (RPT_CALLCENTER_LOG_HISTORY.CREATE_TIME) year,MONTH (RPT_CALLCENTER_LOG_HISTORY.CREATE_TIME) month,count(1) count,LARGER_REGION_CODE "+
 " FROM DDMPWebService.dbo.RPT_CALLCENTER_LOG_HISTORY, DDMPWebService.dbo.viewDealerRegion vdr "+
 " WHERE RPT_CALLCENTER_LOG_HISTORY.CREATE_TIME BETWEEN '2018-01-01' AND '2019-01-01' and dbo.RPT_CALLCENTER_LOG_HISTORY.FK_DEALER_ID=vdr.DEALER_ID "+
 " group by USER_KEY,datepart(week,RPT_CALLCENTER_LOG_HISTORY.CREATE_TIME),YEAR (RPT_CALLCENTER_LOG_HISTORY.CREATE_TIME),MONTH (RPT_CALLCENTER_LOG_HISTORY.CREATE_TIME), LARGER_REGION_CODE,day( RPT_CALLCENTER_LOG_HISTORY.CREATE_TIME) "); 

    System.out.println("=======1");
    
    CsvWriterSettings cws= new CsvWriterSettings();
    cws.setHeaderWritingEnabled(true);
    cws.setRowWriterProcessor(new BeanWriterProcessor(ReportCount.class));
    CsvWriter writer = new CsvWriter(response.getWriter(),cws );
    
    response.setContentType("application/csv;charset=GB2312");
    response.setHeader("Content-Disposition", "attachment;filename=400report.csv");
    try{
    while(rs.next()){
       ReportCount rc=new ReportCount();
       rc.setMedia(rs.getString("media"));
       rc.setWeek(rs.getInt("week"));
       rc.setDay(rs.getString("day"));
       rc.setYear(rs.getInt("year"));
       rc.setMonth(rs.getInt("month"));
       rc.setCount(rs.getInt("count"));
       rc.setRsd(rs.getString("LARGER_REGION_CODE"));
        rc.setSeries("");
       rc.setCatename("");
       rc.setHiname(rs.getString(""));
       writer.processRecord(rc);
    }
    }catch(Exception e){
        e.printStackTrace();
    }
    writer.close();


%>