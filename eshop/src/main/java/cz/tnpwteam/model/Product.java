package cz.tnpwteam.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Admin on 28.5.2016.
 */
@Entity
@Table(name = "product")
public class Product {
    private Long id;
    private String type;
    private BigDecimal price;
    private String category;
    private String image;
    private Long orderId;

    public Product(Long id, String type, BigDecimal price, String category) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.category = category;
    }

    public Product(Long id, String type, BigDecimal price, String category, String image, Long orderId) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.category = category;
        this.image = image;
        this.orderId = orderId;
    }

    public Product() {
    }

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    @Column(name = "idOrder", nullable = true)
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "image", nullable = false)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public void setCategory(String category) {
        this.category = category;
    }

}
