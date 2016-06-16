package cz.tnpwteam.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Admin on 11.4.2016.
 */
//@Entity
public class Cart {

    public Cart() {
    }

    public Cart(List<Product> products) {
        this.products = products;
    }

    private Integer id;
    private List<Product> products;
    private Integer idUser;
    private BigDecimal totalValue;

    public void addProduct(Product p) {
        products.add(p);
    }

    public void removeProduct(Product p) {
        products.remove(p);
    }

    public BigDecimal calculateTotalValue() {
        BigDecimal total = new BigDecimal(BigDecimal.ROUND_HALF_UP);
        for (Product prod : products) {
            total.add(prod.getPrice());
        }
        return total;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

}
