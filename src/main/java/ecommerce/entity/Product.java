package ecommerce.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
//@Table(name = "products")
//@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private double price;
    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<CartLine> listProduct;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Feedback> feedback;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public Product(Long productId, String name, String brand, String description, String image, double price, String status,
                    Category category) {
        this.productId = productId;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.image = image;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<CartLine> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<CartLine> listProduct) {
        this.listProduct = listProduct;
    }

    public List<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price + '\'' +
                ", status=" + status +
                ", category=" + category +
                '}';
    }
}
