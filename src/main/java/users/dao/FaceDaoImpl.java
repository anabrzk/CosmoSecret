package users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import users.model.Face;

import java.util.List;

@Repository
public class FaceDaoImpl implements FaceDao{

    private static final Logger logger = LoggerFactory.getLogger(FaceDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addFace(Face face) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(face);
        logger.info("Face successfully saved. Face details: " + face);
    }

    @Override
    public void updateFace(Face face) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(face);
        logger.info("Face successfully update. Face details: " + face);
    }

    @Override
    public void removeFace(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Face face = (Face) session.load(Face.class, new Integer(id));

        if(face!=null){
            session.delete(face);
        }
        logger.info("Face successfully removed. Face details: " + face);
    }

    @Override
    public Face getFaceById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Face face = (Face) session.load(Face.class, new Integer(id));
        logger.info("Face successfully loaded. Face details: " + face);

        return face;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Face> getFaceByPrice(int price) {
        Session session =this.sessionFactory.getCurrentSession();
        String query = "select p from " + Face.class.getSimpleName() + " p where price < " + price;
        List<Face> faceList = (List<Face>) session.createQuery(query).list();

        return faceList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Face> listFace() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Face> faceList = session.createQuery("from Face").list();

        for(Face face: faceList){
            logger.info("Face list: " + face);
        }

        return faceList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Face> listFaceOrderAsc() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Face> faceList = (List<Face>) session.createCriteria(Face.class).addOrder(Order.asc("price")).list();

        for(Face face: faceList){
            logger.info("Face list: " + face);
        }

        return faceList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Face> listFaceOrderDesc() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Face> faceList = (List<Face>) session.createCriteria(Face.class).addOrder(Order.desc("price")).list();

        for(Face face: faceList){
            logger.info("Face list: " + face);
        }

        return faceList;
    }

}
