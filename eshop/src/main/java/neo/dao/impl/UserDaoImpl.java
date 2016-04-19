package neo.dao.impl;

import neo.dao.UserDao;
import neo.model.User;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 19.4.2016.
 */
@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory session;


    @Override
    public void addUser(User u) {

    }

    @Override
    public void updateUser(User u) {

    }

    @Override
    public List<User> listUsers() {
        return null;
    }

    @Override
    public User getUserByUserName(int id) {
        return null;
    }

    @Override
    public void removeUser(User u) {

    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
