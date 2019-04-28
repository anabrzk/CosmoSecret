package users.service;

import users.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    public List<User> listUser();

    public User getUserByName(String name);

    public User getUserById(int id);
}
