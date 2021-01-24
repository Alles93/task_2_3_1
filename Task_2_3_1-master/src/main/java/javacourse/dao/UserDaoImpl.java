package javacourse.dao;

import javacourse.model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.unwrap(Session.class).createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.unwrap(Session.class).createQuery("from User where id = '" + id + "'", User.class).getSingleResult();
    }

    @Override
    public void updateUser(User user) {
        entityManager.unwrap(Session.class).saveOrUpdate(user);
        System.out.println("Пользователь обновлен!");
    }

    @Override
    public void saveUser(User user) {
        entityManager.unwrap(Session.class).saveOrUpdate(user);
        System.out.println("Пользователь создан!");
    }

    @Override
    public void deleteUserById(Long id) {
        User user = getUserById(id);
        entityManager.unwrap(Session.class).delete(user);
        System.out.println("Пользователь удален " + id);
    }
}
