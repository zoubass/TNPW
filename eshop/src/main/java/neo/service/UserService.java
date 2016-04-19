package neo.service;

import neo.model.User;

import java.util.List;

/**
 * Created by Admin on 19.4.2016.
 */
public interface UserService {
    void addUser(User u);

    void updateUser(User u);

    List<User> listUsers();

    User getUserByUserName(int id);

    void removeUser(User u);
}
