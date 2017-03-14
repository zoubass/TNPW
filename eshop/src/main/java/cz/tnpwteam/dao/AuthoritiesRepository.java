package cz.tnpwteam.dao;

import cz.tnpwteam.model.Authorities;
import cz.tnpwteam.model.AuthoritiesEnum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 16.6.2016.
 */
@Transactional
public interface AuthoritiesRepository extends CrudRepository<Authorities, Long> {

    @Query("select A from Authorities A where A.username=:username")
    List<Authorities> filterByUsername(@Param("username") String username);
}
