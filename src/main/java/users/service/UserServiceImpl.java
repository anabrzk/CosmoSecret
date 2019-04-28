package users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import users.dao.UserDao;
import users.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public List<User> listUser() {
        return this.userDao.listUser();
    }

    @Override
    @Transactional
    public User getUserByName(String name) {
        return this.userDao.getUserByName(name);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }


}
