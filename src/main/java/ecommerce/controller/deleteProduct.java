package ecommerce.controller;

import ecommerce.dao.*;
import ecommerce.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/deleteProduct"})
public class deleteProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long productId = Long.parseLong(req.getParameter("productId"));

        try {
            //Product product = ProductDAO.getInstance().findByID(productId);
            //product.getActiveProduct("status");

            ProductDAO.getInstance().deleteProduct(productId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
