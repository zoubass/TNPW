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


    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
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
