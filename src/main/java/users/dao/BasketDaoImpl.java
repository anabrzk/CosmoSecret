package users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import users.model.Basket;
import users.model.Type;

import java.util.List;

@Repository
public class BasketDaoImpl implements BasketDao {

    private static final Logger logger = LoggerFactory.getLogger(BasketDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBasket(Basket basket) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(basket);
        logger.info("Basket successfully saved. Basket details: " + basket);
    }

    @Override
    public void updateBasket(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Basket basket = (Basket) session.load(Basket.class, new Integer(id));
        basket.setState(1);
        session.update(basket);
        logger.info("Basket successfully update. Basket details: " + basket);
    }

    @Override
    public void removeBasket(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Basket basket = (Basket) session.load(Basket.class, new Integer(id));

        if(basket!=null){
            session.delete(basket);
        }
        logger.info("Basket successfully removed. Basket details: " + basket);
    }

    @Override
    public Basket getBasketById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Basket basket = (Basket) session.load(Basket.class, new Integer(id));
        logger.info("Basket successfully loaded. Basket details: " + basket);

        return basket;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Basket> listBasket() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Basket> basketList = session.createQuery("from Basket").list();
        for(Basket basket: basketList){
            logger.info("Basket list: " + basket);
        }

        return basketList;
    }
}
