package ecommerce.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
//@Table(name = "carts")
public class Cart implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cartId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart", cascade = CascadeType.ALL)
//    private Set<CartLine> listCart = new HashSet<>();
    private List<CartLine> listCart;
    @Column(name = "total_product")
    private int totalProduct;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "voucher")
    private String voucher;

    public Cart() {
    }

    public Cart( int cartId, Account account, List<CartLine> listCart, int totalProduct, double totalPrice, String voucher) {
        this.cartId = cartId;
        this.account = account;
//        this.listCart = listCart;
        this.totalProduct = totalProduct;
        this.totalPrice = totalPrice;
        this.voucher = voucher;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    //
//    public List<CartLine> getProduct() {
//        return product;
//    }
//
//    public void setProduct(List<CartLine> product) {
//        this.product = product;
//    }
    public List<CartLine> getListCart() {
        return listCart;
    }

    public void setListCart(List<CartLine> listCart) {
        this.listCart = listCart;
    }

    public int getTotalProduct() {
        return totalProduct;
    }

    public void setTotalProduct(int totalProduct) {
        this.totalProduct = totalProduct;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", account=" + account +
                ", totalProduct=" + totalProduct +
                ", totalPrice=" + totalPrice +
                ", voucher='" + voucher + '\'' +
                '}';
    }
    public void addItem(CartLine item) {
        Long code = item.getProduct().getProductId();
        int quantity = item.getQuantity();
        for (CartLine cartItem : listCart) {
            if (cartItem.getProduct().getProductId().equals(code)) {
                cartItem.setQuantity(quantity + item.getQuantity());
                return;
            }
        }
        listCart.add(item);
    }

    public void removeItem(CartLine item) {
        Long code = item.getProduct().getProductId();
        for (int i = 0; i < listCart.size(); i++) {
            CartLine lineItem = listCart.get(i);
            if (lineItem.getProduct().getProductId().equals(code)) {
                listCart.remove(i);
                return;
            }
        }
    }

    public void updateItem(CartLine item, int newQuantity) {
        Long code = item.getProduct().getProductId();
        for (CartLine cartLine : listCart) {
            if (cartLine.getProduct().getProductId().equals(code)) {
                cartLine.setQuantity(newQuantity); // Cập nhật số lượng sản phẩm
                return;
            }
        }
    }
}
