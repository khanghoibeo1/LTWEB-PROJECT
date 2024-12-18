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

@WebServlet(urlPatterns = {"/deleteCartItem"})
public class deleteCartItem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null) {
            long productId = Long.parseLong(req.getParameter("productId"));

            // Remove the cart item with the specified productId
            cart.getListCart().removeIf(cartLine -> cartLine.getProduct().getProductId() == productId);

            // Recalculate total price
            recalculateTotalPrice(cart);
        }

        resp.sendRedirect("cart.jsp");
    }

    private void recalculateTotalPrice(Cart cart) {
        double totalPrice = 0.0;
        for (CartLine cartLine : cart.getListCart()) {
            totalPrice += cartLine.getProduct().getPrice() * cartLine.getQuantity();
        }
        cart.setTotalPrice(totalPrice);
    }
}
