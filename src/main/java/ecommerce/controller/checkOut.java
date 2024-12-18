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

@WebServlet(urlPatterns = {"/checkOut"})
public class checkOut extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("Cart");
        Account acc = (Account) session.getAttribute("Account");

        String address = req.getParameter("Address");
        Payment pay = new Payment();
        //pay.setItems(cart.getListCart());
        pay.setAddress(address);
        pay.setAccount(acc);
        pay.setTotalPay(cart.getTotalPrice());

        try {
            PaymentDAO.getInstance().addPayment(pay);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Cart newCart = new Cart();
        //newCart.setAccount(acc.getAccount());
        //Date date = new Date();
        //newCart.setDate(date);
        List<CartLine> items = new ArrayList<>();
        newCart.setListCart(items);
        session.setAttribute("Cart", newCart);

        getServletContext().getRequestDispatcher("/loadProfile").forward(req, resp);

    }
}
