package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> showAllUsers() {
        return userDao.showAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User show(long id) {
        return userDao.show(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public void update(User updatedUser) {
        userDao.update(updatedUser);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(userDao.show(id));
    }
}
