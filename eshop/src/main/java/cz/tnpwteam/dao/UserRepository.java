package cz.tnpwteam.dao;

import cz.tnpwteam.model.AuthoritiesEnum;
import cz.tnpwteam.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 5.6.2016.
 */
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select U.username,U.password,U.enabled, A.authority from Authorities A, User U where A.username like CONCAT(:username, '%') and A.username=U.username and A.authority like CONCAT(:authority, '%')")
    List<Object> filterByDto(@Param("username") String username, @Param("authority") AuthoritiesEnum authority);
}
