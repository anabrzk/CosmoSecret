package users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import users.model.Antiage;

import java.util.List;

@Repository
public class AntiageDaoImpl implements AntiageDao {

    private static final Logger logger = LoggerFactory.getLogger(FaceDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAntiage(Antiage antiage) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(antiage);
        logger.info("Antiage successfully saved. Antiage details: " + antiage);
    }

    @Override
    public void updateAntiage(Antiage antiage) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(antiage);
        logger.info("Antiage successfully update. Antiage details: " + antiage);
    }

    @Override
    public void removeAntiage(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Antiage antiage = (Antiage) session.load(Antiage.class, new Integer(id));

        if(antiage !=null){
            session.delete(antiage);
        }
        logger.info("Antiage successfully removed. Antiage details: " + antiage);
    }

    @Override
    public Antiage getAntiageById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Antiage antiage = (Antiage) session.load(Antiage.class, new Integer(id));
        logger.info("Antiage successfully loaded. Antiage details: " + antiage);

        return antiage;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Antiage> getAntiageByPrice(int price) {

        Session session =this.sessionFactory.getCurrentSession();
        String query = "select p from " + Antiage.class.getSimpleName() + " p where price < " + price;
        List<Antiage> antiageList = (List<Antiage>) session.createQuery(query).list();

        return antiageList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Antiage> listAntiage() {

        Session session = this.sessionFactory.getCurrentSession();
        List<Antiage> antiageList = session.createQuery("from Antiage").list();

        for(Antiage antiage : antiageList){
            logger.info("Antiage list: " + antiage);
        }

        return antiageList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Antiage> listAntiageOrderAsc() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Antiage> antiageList = (List<Antiage>) session.createCriteria(Antiage.class).addOrder(Order.asc("price")).list();

        for(Antiage antiage : antiageList){
            logger.info("Antiage list: " + antiage);
        }

        return antiageList;

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Antiage> listAntiageOrderDesc() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Antiage> antiageList = (List<Antiage>) session.createCriteria(Antiage.class).addOrder(Order.desc("price")).list();

        for(Antiage antiage : antiageList){
            logger.info("Antiage list: " + antiage);
        }

        return antiageList;
    }
}
