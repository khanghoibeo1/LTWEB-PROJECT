package ecommerce.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name = "cart_lines")
public class CartLine implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_line_id")
    private int cartLineId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(name = "quantity")
    private int quantity;

    public CartLine() {
    }

    public CartLine(int cartLineId, Product product, Payment payment, Cart cart, int quantity) {
        this.cartLineId = cartLineId;
        this.product = product;
        this.payment = payment;
        this.cart = cart;
        this.quantity = quantity;
    }

    public int getCartLineId() {
        return cartLineId;
    }

    public void setCartLineId(int cartLineId) {
        this.cartLineId = cartLineId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "CartLine{" +
                "cartLineId=" + cartLineId +
                ", product=" + product +
                ", payment=" + payment +
                ", cart=" + cart +
                ", quantity=" + quantity +
                '}';
    }
}
