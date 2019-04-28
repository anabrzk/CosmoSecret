package users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import users.model.Lips;

import java.util.List;

@Repository
public class LipsDaoImpl implements LipsDao {

    private static final Logger logger = LoggerFactory.getLogger(FaceDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addLips(Lips lips) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(lips);
        logger.info("Lips successfully saved. Lips details: " + lips);
    }

    @Override
    public void updateLips(Lips lips) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(lips);
        logger.info("Lips successfully update. Lips details: " + lips);
    }

    @Override
    public void removeLips(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Lips lips = (Lips) session.load(Lips.class, new Integer(id));

        if(lips!=null){
            session.delete(lips);
        }
        logger.info("Lips successfully removed. Lips details: " + lips);
    }

    @Override
    public Lips getLipsById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Lips lips = (Lips) session.load(Lips.class, new Integer(id));
        logger.info("Lips successfully loaded. Lips details: " + lips);

        return lips;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Lips> getLipsByPrice(int price) {
        Session session =this.sessionFactory.getCurrentSession();
        String query = "select p from " + Lips.class.getSimpleName() + " p where price < " + price;
        List<Lips> lipsList = (List<Lips>) session.createQuery(query).list();

        return lipsList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Lips> listLips() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Lips> lipsList = session.createQuery("from Lips").list();

        for(Lips lips: lipsList){
            logger.info("Lips list: " + lips);
        }

        return lipsList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Lips> listLipsBrand() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Lips> lipsList = session.createQuery("from Lips group by brand").list();

        for(Lips lips: lipsList){
            logger.info("Lips list: " + lips);
            System.out.println(lips);
        }

        return lipsList;
    }



    @Override
    @SuppressWarnings("unchecked")
    public List<Lips> listLipsOrderAsc() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Lips> lipsList = (List<Lips>) session.createCriteria(Lips.class).addOrder(Order.asc("price")).list();

        for(Lips face: lipsList){
            logger.info("Lips list: " + face);
        }

        return lipsList;

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Lips> listLipsOrderDesc() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Lips> lipsList = (List<Lips>) session.createCriteria(Lips.class).addOrder(Order.desc("price")).list();

        for(Lips lips: lipsList){
            logger.info("Lips list: " + lips);
        }

        return lipsList;
    }
}
