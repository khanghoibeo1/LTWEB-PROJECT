package ecommerce.controller;

//import ecommerce.dao.*;
//import ecommerce.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/CheckOTP"})
public class CheckOTP extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "";
        String url;
        String otp = req.getParameter("otp");
        if(otp.equals(SendMail.body)) {
            HttpSession session = req.getSession();
            String email = (String) session.getAttribute("email");
            url = "/newpass.jsp";
        }
        else {
            message = "OTP is not correct";
            url = "/otp.jsp";
        }
        req.setAttribute("message", message);
        getServletContext().getRequestDispatcher(url).forward(req,resp);
    }
}
