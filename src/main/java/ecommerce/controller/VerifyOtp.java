package ecommerce.controller;

import ecommerce.dao.*;
import ecommerce.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/VerifyOTP"})
public class VerifyOtp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message;
        String url;
        String otp = req.getParameter("otp");

        if(otp.equals(register.body)) {
            HttpSession session = req.getSession();
            Account acc = (Account) session.getAttribute("acc");
            try {
                AccountDAO.getInstance().insert(acc);
                message = "Register successfully";
                url = "/login.jsp";

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else {
            message = "OTP is not correct";
            url = "/otp.jsp";
        }
        req.setAttribute("message", message);
        getServletContext().getRequestDispatcher(url).forward(req,resp);
    }
}
