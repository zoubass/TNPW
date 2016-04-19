package neo.service.impl;

import neo.dao.UserDao;
import neo.model.User;
import neo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 19.4.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    @Transactional
    public void addUser(User u) {
        userDao.addUser(u);
    }

    @Override
    @Transactional
    public void updateUser(User u) {
        userDao.updateUser(u);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    @Transactional
    public User getUserByUserName(int id) {
        return userDao.getUserByUserName(id);
    }

    @Override
    @Transactional
    public void removeUser(User u) {
        userDao.removeUser(u);
    }
}
