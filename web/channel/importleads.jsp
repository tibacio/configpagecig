<%-- 
    Document   : result
    Created on : 2018-6-11, 17:19:27
    Author     : shengd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../hight/styles/default.css">
      
    </head>
    <body>
        <form action="./doimportleads.jsp" method="post" enctype="multipart/form-data">
            <table style=""  border="2">
                <tr>
                    <td style="width: 100px">线索模板</td><td><a href=".xls">模板下载</a></td>
                </tr>
                <tr>
                    <td style="width: 100px">线索文件</td><td><input type="file" name="leadfile" /></td>
                </tr>
<tr>
    <td  colspan="2"><input type="submit"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
