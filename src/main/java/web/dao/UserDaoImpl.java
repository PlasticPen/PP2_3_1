package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> showAllUsers() {
        return (entityManager.createQuery("select u from User u", User.class).getResultList());

    }

    public User show(int id) {
        String ql = "select u from User u where u.id = :id";
        return (entityManager.createQuery(ql, User.class).setParameter("id", id).getSingleResult());
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(int id, User updatedUser) {
        String ql = "select u from User u where u.id = :id";
        User userToBeUpdated =
                entityManager.createQuery(ql, User.class).setParameter("id", id).getSingleResult();
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
        userToBeUpdated.setEmail(updatedUser.getEmail());

    }

    public void delete(int id) {
        String ql = "select u from User u where u.id = :id";
        User user = entityManager.createQuery(ql, User.class).setParameter("id", id).getSingleResult();
        entityManager.remove(user);
    }
}
