<%-- 
    Document   : function
    Created on : 2018-7-23, 23:43:17
    Author     : baci
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.commons.lang3.time.DateUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <h4><a href="exportleadsreport.jsp">下载总周报数据-线索</a></h4>
        <h4><a href="export400report.jsp">下载总周报数据-400</a></h4>
         <form action="doexportleads.jsp" method="post">
             年份<select name="y">
                 <option value="2015">2015</option>
                 <option value="2016">2016</option>
                 <option value="2017">2017</option>
                 <option value="2018" selected="">2018</option>
                 <option value="2019">2019</option>
                 <option value="2020">2020</option>
             </select>
        月份<select name="st">
                             <option value="">请选择</option>
            <%
                int m=Calendar.getInstance().get(Calendar.MONTH);
                for(int i=1;i<=12;i++){
                    String sel="";
                    if(m==i)
                        sel="selected";
                    
                    
               %>
               <option value="<%=i %>" <%=sel %>><%=i%></option>
            <%
                }
                
                %>
            </select>
            <br/>
            查询区域
            <select name="rsd">
                <option value="">请选择</option>
                <option value="RSD1">RSD1</option>
                <option value="RSD2">RSD2</option>
                <option value="RSD3">RSD3</option>
                <option value="RSD4">RSD4</option>
                <option value="RSD5">RSD5</option>
                <option value="RSD6">RSD6</option>
                
            </select>
            <input type="submit" value="导出明细">
        </form>
    </body>
</html>
