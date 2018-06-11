<%@page import="org.springframework.util.StringUtils"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="bean.ChannelKey"%>
<%@page import="java.util.UUID"%>
<%@page import="org.springframework.jdbc.support.rowset.SqlRowSet"%>
<%@page import="javax.sql.RowSet"%>
<%@page import="org.springframework.jdbc.core.JdbcTemplate"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    JdbcTemplate jt = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

    String key = request.getParameter("ckey");
    int ismedia= Integer.parseInt(request.getParameter("is"));
    List<Map<String,Object>> l = jt.queryForList("SELECT ChannelKey, ContactType, HighLvlChannel, LowLvlChannel, "
            + "SourceDetail, ContactTypeName,HighLvlChannelName, LowLvlChannelName, SOURCEDetailName, IsGenerateCode  "
            + "FROM DDMPWebService.dbo.ViewChannelKey where ChannelKey=?",key);
    
    Map<String,Object> som=l.get(0);
    ChannelKey ck=new ChannelKey(key);
    ck.setCname(som.get("LowLvlChannelName")+"");
    ck.setMedia(som.get("SOURCEDetailName")+"");
    
    List<Map<String,Object>> l1= jt.queryForList("SELECT ID, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DELETE_FLAG, MEDIA_NAME, "
            + "LOCATION, MEDIA_KEY, IS_MEDIA  FROM DDMPWebService.dbo.MGR_MEDIAINFO where MEDIA_NAME=? and "
            + "IS_MEDIA=?",ck.getMedia(),ismedia);
    ck.setUkey(l1.get(0).get("MEDIA_KEY")+"");
    
       List<Map<String,Object>> l2=jt.queryForList("SELECT ID, CHANNEL_KEY, MEDIA_TYPE, MEDIA_NAME, MEDIA_CHANNEL, MEDIA_AD, TERMINAL_TYPE, ACTIVITY_NAME, ACTIVITY_START_TIME, ACTIVITY_END_TIME, SMART_CODE, AD_TYPE, CREATE_TIME, UPDATE_TIME, CREATE_USER, UPDATE_USER, REGION, SERIES, PROVINCE, CITY, LANDING_PAGE_URL, AD_SIZE, NOTE, DELETE_FLAG  FROM DDMPWebService.dbo.SMART_CODE where CHANNEL_KEY=?",ck.getCkey());
    ck.setSmartcode((int)l2.get(0).get("SMART_CODE"));
    request.setAttribute("keybean", ck);

    request.getRequestDispatcher("result.jsp").forward(request, response);


%>
