package bean;


import static bean.WxCorpUtil.WxApiUrl.getUserPrfix;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.io.*;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * 微信企业号工具类
 */

public class WxCorpUtil {

    // 上次获取访问令牌的时间（精确到秒）
    public static long lastGetAccessTokenTimeInSecond;
    // 多长时间过期（单位为秒）
    public static long expiresInSecond;
    // 访问令牌
    public static String accessToken;
    public static String propertyFileName = "wxCorp.properties"; // 微信企业号配置文件
    public static String corpId; // 企业Id
    public static String corpSecret; // 管理组的凭证密钥
    public static String agentId; // 应用ID
    public static String departmentId; // 部门ID
    public static String sEncodingAESKey;
    public static String sToken;
    

    // 微信api请求地址
    public static class WxApiUrl {

        public static String sendMsgPrefix = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token="; // 发送消息
        public static String createUserPrefix = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token="; // 创建用户
        public static String updateUserPrefix = "https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token="; // 更新用户
        public static String deleteUserPrefix = "https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token="; // 删除用户
        public static String getUserPrfix = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential"; // 获取
    }

    private static Logger logger = LoggerFactory.getLogger(WxApiUrl.class);

    // 获取访问令牌
    public static String getAccessToken() throws Exception {
        if (!isNeedGetNewAccessToken()) {
            return accessToken;
        }
        String jsonStr = getHtml(getUserPrfix+"appid=" + corpId + "&secret=" + corpSecret);
        try {
            JsonObject jsonObject = new Gson().fromJson(jsonStr, JsonObject.class);
            String accessTokenKey = "access_token";
            if (jsonObject.has(accessTokenKey)) {
                accessToken = jsonObject.get(accessTokenKey).getAsString();
                expiresInSecond = jsonObject.get("expires_in").getAsLong() - (10 * 60); // 提前10分钟，以防服务器时间不准确
                lastGetAccessTokenTimeInSecond = System.currentTimeMillis() / 1000;
                return accessToken;
            } else {
                logger.error(jsonStr);
                throw new Exception("调用微信接口出错：" + jsonObject.get("errmsg").getAsString());
            }
        } catch (JsonSyntaxException e) {
            logger.error(jsonStr);
            e.printStackTrace();
            throw new Exception("调用微信接口出错：");
        }
    }

    // 是否需要获取一个新的访问令牌
    private static boolean isNeedGetNewAccessToken() {
        if (expiresInSecond <= 0) { // 如果过期时间还未初始化，则需要新的令牌
            return true;
        }
        if (StringUtils.isBlank(accessToken)) { // 如果当前的令牌是空的，则需要新的令牌
            return true;
        }
        long curSecond = System.currentTimeMillis() / 1000; // 当前秒
        long gap = curSecond - lastGetAccessTokenTimeInSecond; // 自上次获取令牌，已经过去了多长时间
        if (gap >= expiresInSecond) { // 如果已经超过过期时间了，则需要新的令牌
            return true;
        }
        return false;
    }

    // 获取html
    public static String getHtml(String urlPath) {
        StringBuffer htmlCode = new StringBuffer();
        try {
            InputStream in;
            URL url = new java.net.URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(4000);// 设置连接超时时间，单位毫秒
            connection.setReadTimeout(4000);// 设置读取数据超时时间，单位毫秒
            connection.setDoOutput(true);// 是否打开输出流 true|false
            connection.setDoInput(true);// 是否打开输入流true|false
            connection.setRequestMethod("GET");// 提交方法POST|GET
            connection.setRequestProperty("User-Agent", "Mozilla/4.0");
            connection.setUseCaches(false);// 是否缓存true|false
            connection.connect();
            in = connection.getInputStream();
            java.io.BufferedReader breader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String currentLine;
            while ((currentLine = breader.readLine()) != null) {
                htmlCode.append(currentLine).append("\n");
            }
        } catch (Exception e) {
            logger.error("获取html失败", e);
        }
        return htmlCode.toString();
    }

    // 获取html
    public static String postHtml(String urlPath, String postParamStr) {
        StringBuffer htmlCode = new StringBuffer();
        try {
            InputStream in;
            URL url = new java.net.URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(4000);// 设置连接超时时间，单位毫秒
            connection.setReadTimeout(4000);// 设置读取数据超时时间，单位毫秒
            connection.setDoOutput(true);// 是否打开输出流 true|false
            connection.setDoInput(true);// 是否打开输入流true|false
            connection.setRequestMethod("POST");// 提交方法POST|GET
            connection.setRequestProperty("User-Agent", "Mozilla/4.0");
            connection.setUseCaches(false);// 是否缓存true|false
            connection.connect();
            OutputStream outputStream = connection.getOutputStream();
            // 注意编码格式，防止中文乱码
            outputStream.write(postParamStr.getBytes("UTF-8"));
            outputStream.close();
            in = connection.getInputStream();
            java.io.BufferedReader breader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String currentLine;
            while ((currentLine = breader.readLine()) != null) {
                htmlCode.append(currentLine).append("\n");
            }
        } catch (Exception e) {
            logger.error("获取html失败", e);
        }
        return htmlCode.toString();
    }

    static {
        Properties properties = loadProperty(); // 加载配置文件
        if (properties == null) {
            logger.error("初始化微信企业号工具类失败");
        }
        corpId = properties.getProperty("corpId");
        corpSecret = properties.getProperty("corpSecret");
        agentId = properties.getProperty("agentId");
        departmentId = properties.getProperty("departmentId");
        sEncodingAESKey = properties.getProperty("sEncodingAESKey");
        sToken = properties.getProperty("sToken");
        if (corpId == null || corpId.trim().equals("")) {
            logger.error("从微信企业号配置文件" + propertyFileName + "获取到的corpId属性为空，请修改");
        }
        if (corpSecret == null || corpSecret.trim().equals("")) {
            logger.error("从微信企业号配置文件" + propertyFileName + "获取到的corpSecret属性为空，请修改");
        }
        if (agentId == null || agentId.trim().equals("")) {
            logger.error("从微信企业号配置文件" + propertyFileName + "获取到的agentId属性为空，请修改");
        }
        if (departmentId == null || departmentId.trim().equals("")) {
            logger.error("从微信企业号配置文件" + propertyFileName + "获取到的departmentId属性为空，请修改");
        }
        if (sEncodingAESKey == null || sEncodingAESKey.trim().equals("")) {
            logger.error("从微信企业号配置文件" + propertyFileName + "获取到的sEncodingAESKey属性为空，请修改");
        }
        if (sToken == null || sToken.trim().equals("")) {
            logger.error("从微信企业号配置文件" + propertyFileName + "获取到的sToken属性为空，请修改");
        }
    }

    /**
     * 加载配置文件
     *
     * @return
     */
    public static Properties loadProperty() {
        InputStream inputStream = null;
        try {
            logger.info("加载配置文件 : " + propertyFileName);
            inputStream = WxCorpUtil.class.getResourceAsStream("/" + propertyFileName);
            if (inputStream == null) {
                logger.error("配置文件不存在：" + propertyFileName);
                return null;
            }
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (Exception e) {
            logger.error("加载配置文件出错", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 将实体类转换成符合微信接口API要求的xml格式
     *
     * @param obj
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @see
     */
    @SuppressWarnings("rawtypes")
    public static String beanToXML(Object obj)
            throws IllegalArgumentException, IllegalAccessException {
        StringBuffer sb = new StringBuffer("<xml>\n");

        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        //父类Class
        Class superClass = clazz.getSuperclass();
        Field[] superFields = superClass.getDeclaredFields();

        //拼装自身的字段和字段值
        String fieldName = null;
        Object mapObj = null;
        for (Field field : fields) {
            field.setAccessible(true);
            fieldName = field.getName();//获得字段名
            mapObj = field.get(obj);//获得字段值

            //如果字段是Map类型，形如ImageRspMsg类中Map字段
            if (mapObj instanceof Map) {
                //迭代map集合
                StringBuffer mapFieldValue = new StringBuffer("");
                String key = "";
                Map castMap = (Map) mapObj;
                Iterator iterator = castMap.keySet().iterator();
                while (iterator.hasNext()) {
                    //迭代
                    key = (String) iterator.next();

                    mapFieldValue.append("<").append(key).append(">");

                    mapFieldValue.append("<![CDATA[").append(castMap.get(key).toString()).append("]]>");

                    mapFieldValue.append("</").append(key).append(">\n");
                }
                sb.append("<").append(fieldName).append(">\n");

                sb.append(mapFieldValue); //map集合内的迭代结果，勿加CDATA

                sb.append("</").append(fieldName).append(">\n");
            } //字段非Map类型，则按照String类型处理（获得value时直接调用toString方法）
            else if (mapObj instanceof List) {

                sb.append("<").append(fieldName).append(">");

                List arrl = (List) mapObj;
                for (int x = 0, xl = arrl.size(); x < xl; x++) {
                    sb.append("<").append("item").append(">");
                    Object o = arrl.get(x);
                    Class cz = o.getClass();
                    Field[] fs = cz.getDeclaredFields();

                    //拼装自身的字段和字段值
                    String fname = null;
                    Object mo = null;
                    for (Field f : fs) {
                        f.setAccessible(true);
                        fname = f.getName();//获得字段名   
                        mo = f.get(o);//获得字段值
                        sb.append("<").append(fname).append(">");
                        sb.append("<![CDATA[").append(mo.toString()).append("]]>");
                        sb.append("</").append(fname).append(">\n");
                    }
                    sb.append("</").append("item").append(">\n");
                }

                sb.append("</").append(fieldName).append(">\n");

            } else {

                sb.append("<").append(fieldName).append(">");

                sb.append("<![CDATA[").append(mapObj.toString()).append("]]>");

                sb.append("</").append(fieldName).append(">\n");
            }
        }

        //拼装父类的字段和字段值
        String superFieldName = "";
        for (Field field : superFields) {
            field.setAccessible(true);
            superFieldName = field.getName();

            sb.append("<").append(superFieldName).append(">");

            sb.append("<![CDATA[").append(field.get(obj).toString()).append("]]>");

            sb.append("</").append(superFieldName).append(">\n");

        }
        sb.append("</xml>");

        return sb.toString();
    }

    public static String getDocXml(InputStream stream) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource(stream);
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();
    }

    /**
     * 解析微信发来的请求（XML）
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static Map<String, String> parseXml(String xml) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        StringReader sr = new StringReader(xml);
        InputSource is = new InputSource(sr);
        Document document = db.parse(is);
        // 将解析结果存储在HashMap中      
        Map<String, String> map = new HashMap<>();

        // 得到XML根元素      
        Element root = document.getDocumentElement();
        // 得到根元素的所有子节点      
        NodeList elementList = root.getChildNodes();
        // 遍历所有子节点      
        for (int i = 0, l = elementList.getLength(); i < l; i++) {
            map.put(elementList.item(i).getNodeName(), elementList.item(i).getTextContent());
        }

        return map;
    }
}
