package ecommerce.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
//@Table(name = "payments")
@NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
public class Payment implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @ManyToOne
    @JoinColumn(name ="account_id")
    private Account account;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "address_delivery")
    private String address;

    @Column(name = "totalPay")
    private double totalPay;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartLine> orderItems;

    public Payment() {
    }

    public Payment(int paymentId, Account account, String paymentMethod, Date date, String address, double totalPay) {
        this.paymentId = paymentId;
        this.account = account;
        this.paymentMethod = paymentMethod;
        this.date = date;
        this.address = address;
        this.totalPay = totalPay;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public List<CartLine> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<CartLine> orderItems) {
        this.orderItems = orderItems;
    }

    public void addItem(CartLine item) {
        Long code = item.getProduct().getProductId();
        int quantity = item.getQuantity();
        for (CartLine cartItem : orderItems) {
            if (cartItem.getProduct().getProductId().equals(code)) {
                cartItem.setQuantity(quantity + item.getQuantity());
                return;
            }
        }
        orderItems.add(item);
    }

    public void removeItem(CartLine item) {
        Long code = item.getProduct().getProductId();
        for (int i = 0; i < orderItems.size(); i++) {
            CartLine lineItem = orderItems.get(i);
            if (lineItem.getProduct().getProductId().equals(code)) {
                orderItems.remove(i);
                return;
            }
        }
    }

    public void updateItem(CartLine item, int newQuantity) {
        Long code = item.getProduct().getProductId();
        for (CartLine cartLine : orderItems) {
            if (cartLine.getProduct().getProductId().equals(code)) {
                cartLine.setQuantity(newQuantity); // Cập nhật số lượng sản phẩm
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", account=" + account +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", date=" + date +
                ", address='" + address + '\'' +
                '}';
    }
}
