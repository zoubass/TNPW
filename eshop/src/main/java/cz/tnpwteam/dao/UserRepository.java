package cz.tnpwteam.dao;

import cz.tnpwteam.dto.UserDto;
import cz.tnpwteam.model.AuthoritiesEnum;
import cz.tnpwteam.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

import java.util.List;

/**
 * Created by Admin on 5.6.2016.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select u.username,u.password,u.enabled, a.authority from User u, " +
            "Authorities a where u.username=a.username and u.username like '%:username%' and a.authority like '%:authority%'")
    List<UserDto> filterByDto(@Param("username") String username, @Param("authority") AuthoritiesEnum authority);
}
