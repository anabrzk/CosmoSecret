package users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import users.model.Clean;

import java.util.List;

@Repository
public class CleanDaoImpl implements CleanDao {

    private static final Logger logger = LoggerFactory.getLogger(FaceDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addClean(Clean clean) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(clean);
        logger.info("Clean successfully saved. Clean details: " + clean);
    }

    @Override
    public void updateClean(Clean clean) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(clean);
        logger.info("Clean successfully update. Clean details: " + clean);
    }

    @Override
    public void removeClean(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Clean clean = (Clean) session.load(Clean.class, new Integer(id));

        if(clean !=null){
            session.delete(clean);
        }
        logger.info("Clean successfully removed. Clean details: " + clean);
    }

    @Override
    public Clean getCleanById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Clean clean = (Clean) session.load(Clean.class, new Integer(id));
        logger.info("Clean successfully loaded. Clean details: " + clean);

        return clean;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Clean> getCleanByPrice(int price) {
        Session session =this.sessionFactory.getCurrentSession();
        String query = "select p from " + Clean.class.getSimpleName() + " p where price < " + price;
        List<Clean> cleanList = (List<Clean>) session.createQuery(query).list();

        return cleanList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Clean> listClean() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Clean> cleanList = session.createQuery("from Clean").list();

        for(Clean clean : cleanList){
            logger.info("Clean list: " + clean);
        }

        return cleanList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Clean> listCleanOrderAsc() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Clean> cleanList = (List<Clean>) session.createCriteria(Clean.class).addOrder(Order.asc("price")).list();

        for(Clean clean : cleanList){
            logger.info("Clean list: " + clean);
        }

        return cleanList;

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Clean> listCleanOrderDesc() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Clean> cleanList = (List<Clean>) session.createCriteria(Clean.class).addOrder(Order.desc("price")).list();

        for(Clean clean : cleanList){
            logger.info("Clean list: " + clean);
        }

        return cleanList;
    }
}
