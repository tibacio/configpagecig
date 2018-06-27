/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.WxCorpUtil;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author baci
 */
public class WeChatAPI extends HttpServlet {

    
    private static Logger logger = LoggerFactory.getLogger(WeChatAPI.class);
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 企业号的基本信息，配置时填写
        try {
            
            

            //返回数据包中不能有任何其他信息，必须直接把校验串返回
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(WxCorpUtil.sToken, WxCorpUtil.sEncodingAESKey,
                    WxCorpUtil.corpId);

            // 解析出url上的参数值如下：
            String sVerifyMsgSig
                    = request.getParameter("msg_signature");
            String sVerifyTimeStamp
                    = request.getParameter("timestamp");
            String sVerifyNonce
                    = request.getParameter("nonce");
            String sVerifyEchoStr
                    = request.getParameter("echostr"); 
            
            
            // String sVerifyMsgSig =
            // "5c45ff5e21c57e6ad56bac8758b79b1d9ac89fd3";
            // String sVerifyTimeStamp = "1409659589";
            // String sVerifyNonce = "263014780";
            // String sVerifyEchoStr =
            // "P9nAzCzyDtyTWESHep1vC5X9xho/qYX3Zpb4yKa9SKld1DsH3Iyt3tP3zNdtp+4RPcs8TgAE7OaBO+FZXvnaqQ==";
            String sEchoStr; // 需要返回的明文

            sEchoStr = wxcpt.VerifyURL(sVerifyMsgSig, sVerifyTimeStamp, sVerifyNonce, sVerifyEchoStr);
                        
            // 验证URL成功，将sEchoStr返回
            PrintWriter o = response.getWriter();
            o.print((sEchoStr));
            o.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");        //不能做转换，转换后会出现微信xml无法解析的情况
//        response.setCharacterEncoding("UTF-8");
        try {

            processQiyeRequest(request, response);

        } catch (Exception e) {
            //验证URL失败，错误原因请查看异常  
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public String processQiyeRequest(HttpServletRequest request, HttpServletResponse response) {

        // XML格式的消息数据          
        String respXml = null;
        // 默认返回的文本消息内容         
        try {
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(WxCorpUtil.sToken, WxCorpUtil.sEncodingAESKey, WxCorpUtil.corpId);

            String xml = WxCorpUtil.getDocXml(request.getInputStream());

            String sVerifyMsgSig = request.getParameter("msg_signature");
            String sVerifyTimeStamp = request.getParameter("timestamp");
            String sVerifyNonce = request.getParameter("nonce");
            String sMsg = wxcpt.DecryptMsg(sVerifyMsgSig, sVerifyTimeStamp, sVerifyNonce, xml);

            Map<String, String> kv = WxCorpUtil.parseXml(sMsg);

            if (kv.get("MsgType").equals("text")) {
             
            } else {
               
            }


        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respXml;
    }

}
