package neo.dao;

import neo.model.User;

import java.util.List;

/**
 * Created by Admin on 12.4.2016.
 */
public interface UserDao {

    void addUser(User u);

    void updateUser(User u);

    List<User> listUsers();

    User getUserByUserName(int id);

    void removeUser(User u);
}
