package web.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    @SuppressWarnings("unchecked")
    public List<User> index() {
        return (entityManager.createQuery("from User ").getResultList());

    }

    public User show(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class, id);
    }

    public void save(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.save(user);
    }

    public void update(int id, User updatedUser) {
        Session session = entityManager.unwrap(Session.class);
        User userToBeUpdated = session.get(User.class, id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(session.get(User.class, id));
    }
}
