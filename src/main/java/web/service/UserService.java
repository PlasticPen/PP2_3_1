package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> showAllUsers();
    public User show(long id);
    public void save(User user);
    public void update(User updatedUser);
    public void delete(long id);

}
