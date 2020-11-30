package javacourse.service;

import javacourse.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    List<User> listUsers();

    User getUserById(Long id);
}
