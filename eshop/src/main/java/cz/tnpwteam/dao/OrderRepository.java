package cz.tnpwteam.dao;

import cz.tnpwteam.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Admin on 15.6.2016.
 */
@Transactional
public interface OrderRepository extends CrudRepository<Order, Long> {
}
