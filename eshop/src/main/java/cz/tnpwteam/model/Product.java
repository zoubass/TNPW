package cz.tnpwteam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Admin on 28.5.2016.
 */
@Entity
@Table(name = "product")
public class Product {
    private Long id;
    private String type;
    private Integer price;
    private String category;


    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }


    public void setPrice(Integer price) {
        this.price = price;
    }


    public void setCategory(String category) {
        this.category = category;
    }

}
