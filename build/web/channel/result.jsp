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
    </head>
    <body>
        <table style="border:2px solid  window"  border="2">
            <tr>
                <td style="width: 100px">接口地址</td><td>http://ddmp.audi-online.cn:86/BaseInfoService.svc?wsdl</td>
            </tr>
            <tr>
                <td >
                    java版本
                </td>
                <td >
                    String yds11 = "{'RequestObjectList':[{'ADDRESS':null,'BIRTHDAY':null,'BUSINESS_PHONE':null,'BUY_PLAN_TIME_CODE':0," +
            "'GENDER':null, 'INDUSTRY':null,'LEAD_TYPE':'<%=ck.getCkey()%>','SMART_CODE':'<%=ck.getSmartcode()%>','CUSTOMER_NAME':'<font style="color: red">INPUT</font>'," +
            "'MEDIA_LEAD_ID':'<%=ck.getUkey()%>_<font style="color: red">随机数(最好能与贵司系统数据id匹配)</font>',  'MOBILE':'<font style="color: red">INPUT</font>','MODEL':null,'ORDER_TIME':'0'," +
            "'PHONE':null,'PROFESSION':null,'PROVINCE':<font style="color: red">经销商表省份id</font>,'SERIES':'<font style="color: red">车系表SERIES_ID</font>','USER_KEY':'<%=ck.getUkey()%>'}],'Key':'<%=ck.getUkey()%>'}";

 <br/>

            BaseInfoServiceStub bstub = new BaseInfoServiceStub();
            <br/>
            org.tempuri.BaseInfoServiceStub.SendLeads sendLeads20 = new org.tempuri.BaseInfoServiceStub.SendLeads();
            <br/>
            sendLeads20.setInputParam(yds11);
            <br/>
            System.out.println(bstub.sendLeads(sendLeads20).getSendLeadsResult());
        </td>                
    </tr>
    <tr>
        <td >
            PHP版本
        </td>
        <td >
            header('Content-Type:text/html; charset=utf-8');//设置编码方式UTF-8<br/>
            ini_set('soap.wsdl_cache_enabled','0');//关闭缓存<br/>
            $soap=new SoapClient('http://ddmp.audi-online.cn:86/BaseInfoService.svc?wsdl');//这里是webservice的访问地址<br/>
            $para = array('Key'=>'<%=ck.getUkey()%>','RequestObjectList'=>array(array('ADDRESS'=>null,'BIRTHDAY'=>null,'BUSINESS_PHONE'=>null,'BUY_PLAN_TIME_CODE'=>'0',
            'CAR_COLOR'=>null,'CITY'=>'<font style="color: red">>经销商表城市id</font>','COMMENTS'=>null,'CONTACT_METHOD'=>null,'CUSTOMER_NAME'=>'<font style="color: red">INPUT</font>','FK_DEALER_ID'=>'<font style="color: red">经销商表DEALER_ID</font>',
            'GENDER'=>null, 'INDUSTRY'=>null,'LEAD_TYPE'=>'<%=ck.getCkey()%>',
            'MEDIA_LEAD_ID'=>'<%=ck.getUkey()%>__<font style="color: red">随机数(最好能与贵司系统数据id匹配)</font>','MOBILE'=>'<font style="color: red">>INPUT</font>','MODEL'=>null,'ORDER_TIME'=>'0',
            'PHONE'=>null,'PROFESSION'=>null,'PROVINCE'=>'<font style="color: red">经销商表省份id</font>','SERIES'=>'<font style="color: red">车系表SERIES_ID</font>','USER_KEY'=>'<%=ck.getUkey()%>','SMART_CODE'=>'<%=ck.getSmartcode()%>')));//设置参数 参数为数组方式传递空数组用array 参数之间用，分隔。 key value形式 => 为指向值<br/>
            $Jsondata = json_encode($para); //将参数转成json格式
            $date = array('inputParam'=>$Jsondata);//inputParam为数据 => 指向$Jsondata<br/>
            $result = $soap->SendLeads($date); // $soap是webservice对象 对象调用方法 GetCity（$date 参数）<br/>
       
            $array = get_object_vars($result);<br/>
            var_dump($array);<br/>
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
