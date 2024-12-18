package ecommerce.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name = "feedbacks")
public class Feedback implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private int feedbackId;

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Feedback(){
    }

    public Feedback(int feedbackId , String content, Account account, Product product) {
        this.feedbackId = feedbackId;
        this.content = content;
        this.account = account;
        this.product = product;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", content='" + content + '\'' +
                ", account=" + account +
                ", product=" + product +
                '}';
    }
}

