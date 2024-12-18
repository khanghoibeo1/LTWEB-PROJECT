package ecommerce.controller;

import org.json.JSONArray;
import org.json.JSONObject;

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
import java.util.Date;
import java.util.Random;

@WebServlet(urlPatterns = {"/register"})
public class register extends HttpServlet {
    public static String body;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String message = null;
        String url = "/register.jsp";
                
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String passwordconfirm = req.getParameter("confirmPassword");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String gender = req.getParameter("gender");
        String avatar = req.getParameter("avatar");
        String date = req.getParameter("date");
        String address = req.getParameter("address");
        Account acc = new Account();
        acc.setUserName(userName);
        acc.setPassWord(password);
        acc.setPhone(phone);
        acc.setEmail(email);
        acc.setFirstName(firstName);
        acc.setLastName(lastName);
        acc.setGender(gender);
        acc.setAvatar(avatar);
        acc.setAddress(address);

        acc.setAdmin(false);
        acc.setStatus("acctive");

        acc.setDate(date);
        try{
            if (AccountDAO.getInstance().checkAccountByUsername(userName)){
//                System.out.println("!1");
                message = "This account has already registered";
            }
            else if(AccountDAO.getInstance().checkAccountByEmail(email)) {
//                System.out.println("!2");
                message = "This email has already registered";
            }
            else if(!password.equals(passwordconfirm)) {
                // Password and confirm password do not match
                message = "Password and confirm password do not match";
            }
            else {
                String from = "thedan1304@gmail.com";
                String subject = "web";
                String to = req.getParameter("email");
                body = generateOtp();
                try {
                    MailUtil.sendMail(to, from, subject, body, true);
                    message = "OTP has been sent to " + email;
                    url = "/otp.jsp";
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpSession session = req.getSession();
        session.setAttribute("acc", acc);

        req.setAttribute("acc", acc);
        req.setAttribute("message", message);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
    private String generateOtp() {
        Random random = new Random();
        int otp = random.nextInt(900000) + 100000;
        return String.valueOf(otp);
    }

}
