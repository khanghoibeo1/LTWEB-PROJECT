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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/login"}, name = "1234")
public class logIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "";
        String url = "/login.jsp";
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");
        String action = req.getParameter("action");
        HttpSession session = req.getSession();

        try {
            Account acc = AccountDAO.getInstance().accountLogin(username, password);

            if (acc != null && action.equals("login")) {
                if(acc.isAdmin()){
                    url = "/admin.jsp";
                    List<Product> productList = ProductDAO.getInstance().getActiveProduct();

                    // Set the product list as a request attribute
                    req.setAttribute("productList", productList);

                    session.invalidate(); // Invalidate the old session
                    session = req.getSession(true); // Create a new session

                    session.setAttribute("acc", acc);
                }else{
                    url = "/index.jsp";

                    session.invalidate(); // Invalidate the old session
                    session = req.getSession(true); // Create a new session

                    session.setAttribute("acc", acc);

                    Cart cart = new Cart();
                    List<CartLine> items = new ArrayList<>();
                    cart.setListCart(items);

                    session.setAttribute("Cart", cart);
                }
            }else {
                message = "Wrong username or password!";
                req.setAttribute("message", message);
            }
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            e.printStackTrace();
            req.setAttribute("message", "An error occurred during login.");
        }

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp );
    }
}
