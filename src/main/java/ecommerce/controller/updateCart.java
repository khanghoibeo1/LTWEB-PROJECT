package ecommerce.controller;

import ecommerce.dao.*;
import ecommerce.entity.*;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/updateCart"})
public class updateCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = getSessionCart(req, resp);


        Long productId = Long.parseLong(req.getParameter("productId"));
        Integer quantity = Integer.parseInt(req.getParameter("quantity"));

        for(CartLine item : cart.getListCart()) {
            if (item.getProduct().getProductId().equals(productId)) {
                item.setQuantity(quantity);
            }
        }
        HttpSession session = req.getSession();
        session.setAttribute("Cart", cart);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        JSONArray jsonArray = printJSONCart(cart);
        resp.getWriter().write(jsonArray.toString());
    }

    Cart getSessionCart (HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("Cart");
        return cart;
    }

    JSONArray printJSONCart (Cart cart) {

        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject = new JSONObject();

        //jsonObject.put("userId", cart.getAccountId());
        //jsonObject.put("Date", cart.getDate());

        double totalPrice = 0;

        for(CartLine item : cart.getListCart()) {
            Product product = null;
            try {
                product = ProductDAO.getInstance().findByID(item.getProduct().getProductId());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            totalPrice += product.getPrice() * item.getQuantity();

            JSONObject jsonObjectItem = new JSONObject();

            jsonObjectItem.put("productId", product.getProductId());
            jsonObjectItem.put("Name", product.getName());
            jsonObjectItem.put("Image", product.getImage());
            jsonObjectItem.put("Price", product.getPrice());
            jsonObjectItem.put("Quantity", item.getQuantity());

            jsonObject.append("cartItems",jsonObjectItem);
        }

        jsonObject.put("totalPrice", totalPrice);

        jsonArray.put(jsonObject);

        System.out.println(jsonArray);
        return jsonArray;
    }
}
