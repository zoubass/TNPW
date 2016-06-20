package cz.tnpwteam.dao;

import cz.tnpwteam.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Admin on 7.6.2016.
 */
@Transactional
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT P from Product P where P.type like CONCAT(:name, '%') and P.category like CONCAT(:category, '%')")
    List<Product> findSpecificProducts(@Param("name") String name,/* @Param("price") BigDecimal price,*/ @Param("category") String category);
}
