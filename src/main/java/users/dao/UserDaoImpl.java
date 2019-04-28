package users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import users.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    private static final Logger logger = LoggerFactory.getLogger(FaceDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User successfully saved. User details: " + user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUser() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();

        for(User user: userList){
            logger.info("User list: " + user);
        }

        return userList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserByName(String user) {
        Session session =this.sessionFactory.getCurrentSession();
        String query = "select p from " + User.class.getSimpleName() + " p where username='" + user+"'";
        User userid = (User) session.createQuery(query).uniqueResult();

        return userid;
    }

    @Override
    public User getUserById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User successfully loaded. User details: " + user);

        return user;
    }
}
