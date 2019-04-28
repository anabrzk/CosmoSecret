package users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import users.model.Brows;

import java.util.List;

@Repository
public class BrowsDaoImpl implements BrowsDao {

    private static final Logger logger = LoggerFactory.getLogger(FaceDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBrows(Brows brows) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(brows);
        logger.info("Brows successfully saved. Brows details: " + brows);
    }

    @Override
    public void updateBrows(Brows brows) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(brows);
        logger.info("Brows successfully update. Brows details: " + brows);

    }

    @Override
    public void removeBrows(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Brows brows = (Brows) session.load(Brows.class, new Integer(id));

        if(brows !=null){
            session.delete(brows);
        }
        logger.info("Brows successfully removed. Brows details: " + brows);
    }

    @Override
    public Brows getBrowsById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Brows brows = (Brows) session.load(Brows.class, new Integer(id));
        logger.info("Brows successfully loaded. Brows details: " + brows);

        return brows;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Brows> getBrowsByPrice(int price) {
        Session session =this.sessionFactory.getCurrentSession();
        String query = "select p from " + Brows.class.getSimpleName() + " p where price < " + price;
        List<Brows> browsList = (List<Brows>) session.createQuery(query).list();

        return browsList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Brows> listBrows() {

        Session session = this.sessionFactory.getCurrentSession();
        List<Brows> browsList = session.createQuery("from Brows").list();

        for(Brows brows : browsList){
            logger.info("Brows list: " + brows);
        }

        return browsList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Brows> listBrowsOrderAsc() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Brows> browsList = (List<Brows>) session.createCriteria(Brows.class).addOrder(Order.asc("price")).list();

        for(Brows brows : browsList){
            logger.info("Brows list: " + brows);
        }

        return browsList;

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Brows> listBrowsOrderDesc() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Brows> browsList = (List<Brows>) session.createCriteria(Brows.class).addOrder(Order.desc("price")).list();

        for(Brows brows : browsList){
            logger.info("Brows list: " + brows);
        }

        return browsList;
    }
}
