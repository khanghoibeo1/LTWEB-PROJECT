package ecommerce.controller;

import ecommerce.dao.*;
import ecommerce.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/searchProduct"})
public class searchProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = null;

        String searchString = req.getParameter("search");
        List<Product> productList = null;
        try {
            productList = ProductDAO.getInstance().searchActiveProduct(searchString);

            if(productList.isEmpty()){
                message = "Can not find any result for " + searchString;
                req.setAttribute("message", message);
            }
            else{
                req.setAttribute("listProduct", productList);
            }
            getServletContext().getRequestDispatcher("/products.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = null;

        String searchString = req.getParameter("search");
        List<Product> productList = null;
        try {
            productList = ProductDAO.getInstance().searchProduct(searchString);

            if(productList.isEmpty()){
                message = "Can not find any result for " + searchString;
                req.setAttribute("message", message);
            }
            else{
                req.setAttribute("productList", productList);
            }
            getServletContext().getRequestDispatcher("/admin.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
