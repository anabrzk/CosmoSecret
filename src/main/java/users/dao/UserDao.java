package users.dao;

import users.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);

    public List<User> listUser();

    public User getUserByName(String name);

    public User getUserById(int id);
}
