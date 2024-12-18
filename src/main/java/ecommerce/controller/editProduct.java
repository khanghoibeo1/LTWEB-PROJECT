package ecommerce.controller;

import ecommerce.dao.*;
import ecommerce.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@WebServlet(urlPatterns = {"/editProduct"})
@MultipartConfig
public class editProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String downloadUrlImage;

        Long productId = Long.parseLong(req.getParameter("productId"));
       
        String name = req.getParameter("name");
        String brand = req.getParameter("bard");
        String description = req.getParameter("description");
        String status = req.getParameter("status");
        String image = req.getParameter("image");
        Double price = Double.valueOf(req.getParameter("price"));

        String categoryName = req.getParameter("categoryName");

        Category category;

        try {
            category = CategoryDAO.getInstance().getCategoryByName(categoryName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }       
        
        Product p = new Product();
        p.setProductId(productId);
        p.setName(name);
        p.setBrand(brand);
        p.setCategory(category);
        p.setDescription(description);
        p.setImage(image);
        p.setStatus(status);
        p.setPrice(price);
        
        
        ProductDAO dao = new ProductDAO();
        try {
            dao.getInstance().updateProduct(p);
            //response.sendRedirect("manager");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        getServletContext().getRequestDispatcher("/loadAdminPage").forward(req, resp);
    }
}
