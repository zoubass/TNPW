package cz.tnpwteam.dao;

import cz.tnpwteam.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Admin on 7.6.2016.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
}
