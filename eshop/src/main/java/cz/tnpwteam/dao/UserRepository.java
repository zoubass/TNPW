package cz.tnpwteam.dao;

import cz.tnpwteam.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Admin on 5.6.2016.
 */
public interface UserRepository extends CrudRepository<User,Long>{
}
