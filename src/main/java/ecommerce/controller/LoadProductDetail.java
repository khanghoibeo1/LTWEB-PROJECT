package ecommerce.controller;

import ecommerce.dao.ProductDAO;
import ecommerce.entity.Account;
import ecommerce.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/loadProductDetail")
public class LoadProductDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String productIdString = req.getParameter("productId");

            if (productIdString != null && !productIdString.isEmpty()) {
                // Retrieve product details by ID from the database
                Long productId = Long.parseLong(productIdString);
                Product product = ProductDAO.getInstance().findByID(productId);

                // Set the product as a request attribute
                req.setAttribute("product", product);

                // Forward the request to the product_detail.jsp page
                req.getRequestDispatcher("/product_detail.jsp").forward(req, resp);
            } else {
                // Handle the case when no product ID is provided
                resp.sendRedirect("product.jsp");
            }
        } catch (Exception e) {
            throw new ServletException("Error loading product details", e);
        }
    }
}
