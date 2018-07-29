
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
    SqlRowSet rs = jt.queryForRowSet("SELECT  allleads.media,  datepart(week,allleads.CREATE_TIME) week,day( allleads.create_time) day,YEAR (allleads.CREATE_TIME) year,MONTH (allleads.CREATE_TIME) month,count(1) count,vdr.LARGER_REGION_CODE, allleads.SERIES_NAME, allleads.catetype,allleads.HighLvlChannelName"+
" FROM DDMPWebService.dbo.allleads,DDMPWebService.dbo.viewDealerRegion vdr WHERE allleads.CREATE_TIME BETWEEN '2018-01-01' AND '2019-07-01' and allleads.FK_DEALER_ID=vdr.DEALER_ID "+
" group by media,datepart(week,allleads.CREATE_TIME),day( allleads.create_time),YEAR (allleads.CREATE_TIME),MONTH (allleads.CREATE_TIME), vdr.LARGER_REGION_CODE,allleads.SERIES_NAME, allleads.catetype,allleads.HighLvlChannelName");

    
    CsvWriterSettings cws= new CsvWriterSettings();
    cws.setHeaderWritingEnabled(true);
    cws.setRowWriterProcessor(new BeanWriterProcessor(ReportCount.class));
    CsvWriter writer = new CsvWriter(response.getWriter(),cws );
    
    response.setContentType("application/csv;charset=GB2312");
    response.setHeader("Content-Disposition", "attachment;filename=leadsreport.csv");
    
    while(rs.next()){
       ReportCount rc=new ReportCount();
       rc.setHiname(rs.getString("HighLvlChannelName"));
       rc.setMedia(rs.getString("media"));
       rc.setWeek(rs.getInt("week"));
       rc.setDay(rs.getString("day"));
       rc.setYear(rs.getInt("year"));
       rc.setMonth(rs.getInt("month"));
       rc.setCount(rs.getInt("count"));
       rc.setRsd(rs.getString("LARGER_REGION_CODE"));
       rc.setSeries(rs.getString("SERIES_NAME"));
       rc.setCatename(rs.getString("catetype"));
       
       writer.processRecord(rc);
    }
    
    writer.close();


%>