package ecommerce.controller;

import ecommerce.dao.*;
import ecommerce.entity.*;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "forgetOtp", urlPatterns = {"/forgetOtp"})
public class SendMail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    public static String body;

    public static String to;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

//        String email = req.getParameter("email");
        String from = "thedan1304@gmail.com";
        String subject = "Web Bán Hàng";
        to = req.getParameter("email");
        String message = null;


        body = generateOtp();
//        System.out.println(body);
        String url = "/forgotpassword.jsp";
        try{
            if (!AccountDAO.getInstance().checkAccountByEmail(to)) {
                message = "Email has not been registered";
            }
            else{
                try {
                    MailUtil.sendMail(to, from, subject, body, true);
                    message = "OTP has been sent to " + to;
                    url = "/forgototp.jsp";
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpSession session = req.getSession();
        session.setAttribute("email", to);

        req.setAttribute("email", to);
        req.setAttribute("message", message);
        getServletContext().getRequestDispatcher(url).forward(req, resp);

//        try{
//            if(AccountDAO.checkAccountByEmail(to)){
//                session.setAttribute("email", to);
//                url = "./forgototp.jsp";
//            }
//            else {
//                message = "Email has not been registered";
//                req.setAttribute("message", message);
//                url = "/forgotpassword.jsp";
//            }
//        }catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//
////        try {
////            MailUtil.sendMail(to, from, subject, body, true);
////            //resp.getWriter().write("Đã gửi, Vui lòng check mail của bạn");
////            url = "/otp.jsp";
////        } catch (MessagingException e) {
////            throw new RuntimeException(e);
////        }
//        getServletContext().getRequestDispatcher(url).forward(req, resp);
//    }
    }
    private String generateOtp() {
        Random random = new Random();
        int otp = random.nextInt(900000) + 100000;
        return String.valueOf(otp);
    }

}
