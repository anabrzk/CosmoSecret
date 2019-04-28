package users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import users.model.Contact;

@Repository
public class ContactDaoImpl implements ContactDao {

    private static final Logger logger = LoggerFactory.getLogger(FaceDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addContact(Contact contact) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(contact);
        logger.info("Contact successfully saved. Contact details: " + contact);
    }
}
