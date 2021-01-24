package javacourse.dao;

import javacourse.model.User;

import java.util.List;

public interface UserDao {

    void updateUser(User user);

    void saveUser(User user);

    void deleteUserById(Long id);

    List<User> getAllUsers();

    User getUserById(Long id);
}
