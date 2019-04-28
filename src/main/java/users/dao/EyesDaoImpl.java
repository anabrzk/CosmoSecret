package users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import users.model.Eyes;

import java.util.List;

@Repository
public class EyesDaoImpl implements EyesDao {
    private static final Logger logger = LoggerFactory.getLogger(EyesDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addEyes(Eyes eyes) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(eyes);
        logger.info("Eyes successfully saved. Eyes details: " + eyes);
    }

    @Override
    public void updateEyes(Eyes eyes) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(eyes);
        logger.info("Eyes successfully update. Eyes details: " + eyes);
    }

    @Override
    public void removeEyes(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Eyes eyes = (Eyes) session.load(Eyes.class, new Integer(id));

        if(eyes!=null){
            session.delete(eyes);
        }
        logger.info("Eyes successfully removed. Eyes details: " + eyes);
    }

    @Override
    public Eyes getEyesById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Eyes eyes = (Eyes) session.load(Eyes.class, new Integer(id));
        logger.info("Eyes successfully loaded. Eyes details: " + eyes);

        return eyes;
    }

    @Override
    public List<Eyes> getEyesByPrice(int price) {
        Session session =this.sessionFactory.getCurrentSession();
        String query = "select p from " + Eyes.class.getSimpleName() + " p where price < " + price;
        List<Eyes> eyesList = (List<Eyes>) session.createQuery(query).list();

        return eyesList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Eyes> listEyes() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Eyes> eyesList = session.createQuery("from Eyes").list();

        for(Eyes eyes: eyesList){
            logger.info("Eyes list: " + eyes);
        }

        return eyesList;
    }

    @Override
    public List<Eyes> listEyesOrderAsc() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Eyes> eyesList = (List<Eyes>) session.createCriteria(Eyes.class).addOrder(Order.asc("price")).list();

        for(Eyes eyes: eyesList){
            logger.info("Eyes list: " + eyes);
        }

        return eyesList;

    }

    @Override
    public List<Eyes> listEyesOrderDesc() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Eyes> eyesList = (List<Eyes>) session.createCriteria(Eyes.class).addOrder(Order.desc("price")).list();

        for(Eyes eyes: eyesList){
            logger.info("Eyes list: " + eyes);
        }

        return eyesList;
    }
}
