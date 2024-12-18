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

@WebServlet(urlPatterns = {"/newPass"})
public class NewPass extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String message = "";
        String url = "/login.jsp";
        String password = req.getParameter("password");
        String conpassword = req.getParameter("conpassword");
        String email = SendMail.to;

        if (password.equals(conpassword)){
            try {
                Account acc = AccountDAO.getInstance().getAccountByEmail(email);
                acc.setPassWord(password);

                AccountDAO.getInstance().update(acc);
                req.setAttribute("message", "Create New Password Success");
                getServletContext().getRequestDispatcher(url).forward(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            req.setAttribute("message", "Confirm Password incorrect");
            url = "/newpass.jsp";
            getServletContext().getRequestDispatcher(url).forward(req, resp);
        }
    }
}
