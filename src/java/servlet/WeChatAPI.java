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
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import weixin.popular.util.SignatureUtil;

/**
 *
 * @author baci
 */
public class WeChatAPI extends HttpServlet {

    private static Logger logger =  Logger.getLogger(WeChatAPI.class);

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

            
            // 解析出url上的参数值如下：
            String sVerifyMsgSig
                    = request.getParameter("signature");
            String sVerifyTimeStamp
                    = request.getParameter("timestamp");
            String sVerifyNonce
                    = request.getParameter("nonce");
            String sVerifyEchoStr
                    = request.getParameter("echostr");
            
            logger.error(sVerifyNonce+" "+ sVerifyMsgSig+" "+sVerifyTimeStamp);
            
            String mytoken = SignatureUtil.generateEventMessageSignature("T5JKLxm1E4", sVerifyTimeStamp, sVerifyNonce);

            if (StringUtils.isNotBlank(mytoken) && StringUtils.equals(mytoken, sVerifyMsgSig)) {
                logger.error("验证通过");
                // 验证URL成功，将sEchoStr返回
                PrintWriter o = response.getWriter();
                o.print((sVerifyEchoStr));
                o.flush();
            } else {
                logger.error("验证失败");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
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
           

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respXml;
    }

}
