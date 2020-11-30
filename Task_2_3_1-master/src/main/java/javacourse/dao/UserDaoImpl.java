package javacourse.dao;

import javacourse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        System.out.println("Пользователь добавлен!");
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        System.out.println("Пользователь обновлен!");

    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        entityManager.remove(user);
        System.out.println("Пользователь удален " + id);

    }

    @Override
    public List<User> listUsers() {
        Query from_user = entityManager.createQuery("from User");
        return from_user.getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}
