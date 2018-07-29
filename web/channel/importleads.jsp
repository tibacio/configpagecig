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
            <div style="width:1000px;align-content: center;text-align: center; ">

                <table style="width: 800px;  "  border="2">
                    <tr>
                        <td style="width: 100px">线索模板</td><td><a href="公共订单导入模版.csv">模板下载</a></td>
                    </tr>
                    <tr>
                        <td style="width: 100px">模板说明</td><td>模板可以用excel打开，保存时请继续选择csv格式保存</td>
                    </tr>
                    <tr>
                        <td style="width: 100px">线索文件</td><td><input type="file" name="leadfile" /></td>
                    </tr>
                    <tr>
                        <td  colspan="2"><input type="submit"></td>
                    </tr>
                </table>
            </div>
        </form>

    </body>
</html>
