<%-- 
    Document   : result
    Created on : 2018-6-11, 17:19:27
    Author     : shengd
--%>

<%@page import="bean.ChannelKey"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ChannelKey ck = (ChannelKey) request.getAttribute("keybean");


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../hight/styles/default.css">
        <script src="../hight/highlight.pack.js"></script>
        <script>hljs.initHighlightingOnLoad();</script>
        <style type="text/css">
            .noticew .hljs-string{
               font-style: italic;
                font-weight: bold;
                color:#f00;
            }
            
               .noticew  {
               font-style: italic;
                font-weight: bold;
                color:#f00;
            }
        </style>
    </head>
    <body>
        <table style="border:2px solid  window"  border="2">
            <tr>
                <td style="width: 100px">接口地址</td><td>http://ddmp.audi-online.cn:86/BaseInfoService.svc?wsdl</td>
            </tr>
             <tr>
                 <td style="width: 100px">业务参数</td><td>
                     leadtype: <font class="noticew"><%=ck.getCkey()%></font> <br/> 
                     USER_KEY: <font class="noticew"><%=ck.getUkey()%></font><br/>
                     SMART_CODE: <font class="noticew"><%=ck.getSmartcode()%></font><br/>
                 </td>
            </tr>
             <tr>
                <td style="width: 100px">接口说明</td><td>以下红色代码部分均需要按根据各自媒体需求进行实现。经销商请下载文件到本地使用。<br/>
                    >>><a href="getDealer.jsp">经销商数据文件请点击下载</a><<<
                </td>
            </tr>
            <tr>
                <td >
                    java版本1 
                </td>
                <td > <div>
                        <pre>
                    <code class="java">

            String yds11 = "{'RequestObjectList':[{'ADDRESS':null,'BIRTHDAY':null,'BUSINESS_PHONE':null,'BUY_PLAN_TIME_CODE':0,'FK_DEALER_ID':'<font class="noticew">经销商表DEALER_ID</font>','CITY':'<font class="noticew">经销商表城市id</font>'" +
            "'GENDER':null, 'INDUSTRY':null,'LEAD_TYPE':'<%=ck.getCkey()%>','SMART_CODE':'<%=ck.getSmartcode()%>','CUSTOMER_NAME':'<font class="noticew">页面提交参数</font>'," +
            "'MEDIA_LEAD_ID':'<%=ck.getUkey()%>_<font class="noticew">随机数(最好能与贵司系统数据id匹配)</font>',  'MOBILE':'<font class="noticew">页面提交参数</font>','MODEL':null,'ORDER_TIME':'0'," +
            "'PHONE':null,'PROFESSION':null,'PROVINCE':<font class="noticew">经销商表省份id</font>,'SERIES':'<font class="noticew">车系表SERIES_ID</font>','USER_KEY':'<%=ck.getUkey()%>'}],'Key':'<%=ck.getUkey()%>'}";
            
            BaseInfoServiceStub bstub = new BaseInfoServiceStub();
          
            org.tempuri.BaseInfoServiceStub.SendLeads sendLeads20 = new org.tempuri.BaseInfoServiceStub.SendLeads();
           
            sendLeads20.setInputParam(yds11);
         
            System.out.println(bstub.sendLeads(sendLeads20).getSendLeadsResult());
             </code>
                        </pre></div>
                </td>                
            </tr>
            <tr>
                <td >
                    java版本2
                </td>
                <td > <div>
                        <pre>
                    <code class="java">

            String yds11 = "{'RequestObjectList':[{'ADDRESS':null,'BIRTHDAY':null,'BUSINESS_PHONE':null,'BUY_PLAN_TIME_CODE':0,'FK_DEALER_ID':'<font class="noticew">经销商表DEALER_ID</font>','CITY':'<font class="noticew">经销商表城市id</font>'" +
            "'GENDER':null, 'INDUSTRY':null,'LEAD_TYPE':'<%=ck.getCkey()%>','SMART_CODE':'<%=ck.getSmartcode()%>','CUSTOMER_NAME':'<font class="noticew">页面提交参数</font>'," +
            "'MEDIA_LEAD_ID':'<%=ck.getUkey()%>_<font class="noticew">随机数(最好能与贵司系统数据id匹配)</font>',  'MOBILE':'<font class="noticew">页面提交参数</font>','MODEL':null,'ORDER_TIME':'0'," +
            "'PHONE':null,'PROFESSION':null,'PROVINCE':<font class="noticew">经销商表省份id</font>,'SERIES':'<font class="noticew">车系表SERIES_ID</font>','USER_KEY':'<%=ck.getUkey()%>'}],'Key':'<%=ck.getUkey()%>'}";
            
               BaseInfoService bis = new BaseInfoService();          
            System.out.println(bis.getBasicHttpBindingIBaseInfoService().sendLeads(yds11));
             </code>
                        </pre></div>
                </td>                
            </tr>
            
            <tr>
                <td >
                    PHP版本
                </td>
                <td  class=""><div>
                        <pre>
             <code class="php">
            header('Content-Type:text/html; charset=utf-8');//设置编码方式UTF-8<br/>
            ini_set('soap.wsdl_cache_enabled','0');//关闭缓存<br/>
            $soap=new SoapClient('http://ddmp.audi-online.cn:86/BaseInfoService.svc?wsdl');//这里是webservice的访问地址<br/>
            $para = array('Key'=>'<%=ck.getUkey()%>','RequestObjectList'=>array(array('ADDRESS'=>null,'BIRTHDAY'=>null,'BUSINESS_PHONE'=>null,'BUY_PLAN_TIME_CODE'=>'0',
            'CAR_COLOR'=>null,'CITY'=>'<font class="noticew">经销商表城市id</font>', 'COMMENTS'=>null,'CONTACT_METHOD'=>null,'CUSTOMER_NAME'=>'<font class="noticew">页面提交参数</font>','FK_DEALER_ID'=>'<font class="noticew">经销商表DEALER_ID</font>',
            'GENDER'=>null, 'INDUSTRY'=>null,'LEAD_TYPE'=>'<%=ck.getCkey()%>',
            'MEDIA_LEAD_ID'=>'<%=ck.getUkey()%>_<font class="noticew">随机数(最好能与贵司系统数据id匹配)</font>','MOBILE'=>'<font class="noticew">页面提交参数</font>','MODEL'=>null,'ORDER_TIME'=>'0',
            'PHONE'=>null,'PROFESSION'=>null,'PROVINCE'=>'<font class="noticew">经销商表省份id</font>','SERIES'=>'<font class="noticew">车系表SERIES_ID</font>','USER_KEY'=>'<%=ck.getUkey()%>','SMART_CODE'=>'<%=ck.getSmartcode()%>')));//设置参数 参数为数组方式传递空数组用array 参数之间用，分隔。 key value形式 => 为指向值<br/>
            $Jsondata = json_encode($para); //将参数转成json格式
            $date = array('inputParam'=>$Jsondata);//inputParam为数据 => 指向$Jsondata<br/>
            $result = $soap->SendLeads($date); // $soap是webservice对象 对象调用方法 GetCity（$date 参数）<br/>
       
            $array = get_object_vars($result);<br/>
            var_dump($array);<br/>
              </code></pre></div>
                </td>                
            </tr>
            <tr>
                <td >
                    python版本
                </td>
                <td >

                </td>                
            </tr>
        </table>
    </body>
</html>
