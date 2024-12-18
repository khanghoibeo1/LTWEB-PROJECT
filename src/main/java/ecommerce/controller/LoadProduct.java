package ecommerce.controller;

import ecommerce.dao.ProductDAO;
import ecommerce.entity.Account;
import ecommerce.entity.Product;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/loadProducts")
public class LoadProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Lấy thông tin tài khoản từ session
            HttpSession session = req.getSession();
            Account account = (Account) session.getAttribute("acc");

            if (account != null) {
                // Nếu là admin, chuyển hướng đến trang admin.jsp
                if (account.isAdmin()) {
                    loadProductsForAdmin(req, resp);
                } else {
                    // Nếu không phải admin, chuyển hướng đến trang product.jsp
                    loadProductsForClient(req, resp);
                }
            } else {
                // Nếu không có thông tin tài khoản, có thể chuyển hướng đến trang đăng nhập hoặc trang lỗi
                resp.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            throw new ServletException("Error loading products", e);
        }
    }

    private void loadProductsForAdmin(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        // Get the list of products from the database

        List<Product> productList = ProductDAO.getInstance().findAll();

        // Set the product list as a request attribute
        req.setAttribute("productList", productList);

        // Forward the request to the admin.jsp page
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }

    private void loadProductsForClient(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        // Get the list of products from the database
        List<Product> productList = ProductDAO.getInstance().getActiveProduct();

        // Set the product list as a request attribute
        req.setAttribute("productList", productList);

        // Forward the request to the product.jsp page
        req.getRequestDispatcher("/product.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
        try {
            List<Product> productList = ProductDAO.getInstance().findAll();
            JSONArray jsonArray = new JSONArray();

            for(Product product : productList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("productId", product.getProductId());
                jsonObject.put("name", product.getName());
                jsonObject.put("brand", product.getPrice());
                jsonObject.put("price", product.getPrice());
                jsonObject.put("category", product.getCategory().getName());
                jsonObject.put("status", product.getStatus());
                jsonObject.put("image", product.getImage());

                jsonArray.put(jsonObject);
            }
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            resp.getWriter().write(jsonArray.toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
