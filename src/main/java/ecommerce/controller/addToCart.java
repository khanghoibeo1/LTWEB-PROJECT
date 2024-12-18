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
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebServlet(urlPatterns = {"/addToCart"})
public class addToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/login.jsp";

        HttpSession session = req.getSession();
        Account acc = (Account) session.getAttribute("acc");

        if (acc == null) {
            resp.sendRedirect("login.jsp");
        }
        else {
            try{
                Long productId = Long.parseLong(req.getParameter("productId"));
                Product product = ProductDAO.getInstance().findByID(productId);
                Cart cart = getOrCreateCart(acc);

                CartLine item = new CartLine();
                item.setProduct(product);
                item.setQuantity(1);
                cart = addItemToCart(cart, item);

//                session.setAttribute("cart", cart);
                CartDAO.getInstance().createCart(cart);
                // Trả về thông báo JSON thành công
                resp.setContentType("application/json");
                resp.getWriter().write("{\"success\": true}");
            }catch (Exception e) {
                // Trả về thông báo JSON lỗi
                resp.setContentType("application/json");
                resp.getWriter().write("{\"success\": false, \"message\": \"Error adding item to cart\"}");
            }
        }

    }

   Cart addItemToCart(Cart cart, CartLine item) {
        List<CartLine> items = cart.getListCart();
        boolean isItemExisted = false;

        //check if the product has already been in ShoppingCart
        //then update amount ++

        if(items != null) {
            for (CartLine i : items) {
                if (i.getProduct().getProductId() == item.getProduct().getProductId()) {
                    i.setQuantity(i.getQuantity() + 1);
                    cart.setTotalPrice(cart.getTotalPrice() + i.getProduct().getPrice());
                    isItemExisted = true;
                }
            }
        }

        //add new if the product is not in ShoppingCart
        if(!isItemExisted) {
            items.add(item);
            cart.setTotalPrice(cart.getTotalPrice() + item.getProduct().getPrice());
        }
        cart.setListCart(items);
        return cart;
    }

    Cart getSessionCart (HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        return cart;
    }

    private Cart getOrCreateCart(Account acc) {
        // Kiểm tra xem giỏ hàng của người dùng đã tồn tại trong cơ sở dữ liệu chưa
        Cart cart = CartDAO.getInstance().getCartByUserId(acc.getAccountId());

        if (cart == null) {
            // Nếu chưa tồn tại, tạo giỏ hàng mới
            cart = new Cart();
            cart.setAccount(acc);
        }

        return cart;
    }
}
