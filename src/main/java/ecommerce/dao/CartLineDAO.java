package ecommerce.dao;

import ecommerce.entity.CartLine;
import ecommerce.entity.Product;

public class CartLineDAO {
    public double totalPrice(){
        double total = 0;
        CartLine cartLine = new CartLine();
        Product p = new Product();
        total = p.getPrice() * cartLine.getQuantity();
        return  total;
    }
}
