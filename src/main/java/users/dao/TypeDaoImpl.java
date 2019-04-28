package users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import users.model.Type;

import java.util.List;


@Repository
public class TypeDaoImpl implements TypeDao {
    private static final Logger logger = LoggerFactory.getLogger(TypeDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addType(Type type) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(type);
            logger.info("Type successfully saved. Type details: " + type);
    }

    @Override
    public void updateType(Type type) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(type);
        logger.info("Type successfully update. Type details: " + type);
    }

    @Override
    public void removeType(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Type type = (Type) session.load(Type.class, new Integer(id));

        if(type!=null){
            session.delete(type);
        }
        logger.info("Type successfully removed. Type details: " + type);
    }

    @Override
    public Type getTypeById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Type type = (Type) session.load(Type.class, new Integer(id));
        logger.info("Type successfully loaded. Type details: " + type);

        return type;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Type> listType() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Type> typeList = session.createQuery("from Type").list();
        for(Type type: typeList){
            logger.info("Type list: " + type);
        }

        return typeList;
    }
}
