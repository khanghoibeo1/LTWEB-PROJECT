package ecommerce.controller;

import ecommerce.entity.Cart;
import ecommerce.entity.CartLine;
import ecommerce.entity.Product;
import ecommerce.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/editCartItem"})
public class editCartItem extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null) {
            long productId = Long.parseLong(req.getParameter("productId"));
            int newQuantity = Integer.parseInt(req.getParameter("newQuantity"));

            for (CartLine cartLine : cart.getListCart()) {
                if (cartLine.getProduct().getProductId() == productId) {
                    cartLine.setQuantity(newQuantity);
                    recalculateTotalPrice(cart);
                    break;
                }
            }
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
