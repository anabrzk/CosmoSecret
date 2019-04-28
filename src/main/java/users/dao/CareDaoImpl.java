package users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import users.model.Care;

import java.util.List;

@Repository
public class CareDaoImpl implements CareDao {

    private static final Logger logger = LoggerFactory.getLogger(FaceDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCare(Care care) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(care);
        logger.info("Care successfully saved. Care details: " + care);
    }

    @Override
    public void updateCare(Care care) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(care);
        logger.info("Care successfully update. Care details: " + care);
    }

    @Override
    public void removeCare(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Care care = (Care) session.load(Care.class, new Integer(id));

        if(care !=null){
            session.delete(care);
        }
        logger.info("Care successfully removed. Care details: " + care);
    }

    @Override
    public Care getCareById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Care care = (Care) session.load(Care.class, new Integer(id));
        logger.info("Care successfully loaded. Care details: " + care);

        return care;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Care> getCareByPrice(int price) {
        Session session =this.sessionFactory.getCurrentSession();
        String query = "select p from " + Care.class.getSimpleName() + " p where price < " + price;
        List<Care> careList = (List<Care>) session.createQuery(query).list();

        return careList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Care> listCare() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Care> careList = session.createQuery("from Care").list();

        for(Care care : careList){
            logger.info("Care list: " + care);
        }

        return careList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Care> listCareOrderAsc() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Care> careList = (List<Care>) session.createCriteria(Care.class).addOrder(Order.asc("price")).list();

        for(Care care : careList){
            logger.info("Care list: " + care);
        }

        return careList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Care> listCareOrderDesc() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Care> careList = (List<Care>) session.createCriteria(Care.class).addOrder(Order.desc("price")).list();

        for(Care care : careList){
            logger.info("Care list: " + care);
        }

        return careList;
    }
}
