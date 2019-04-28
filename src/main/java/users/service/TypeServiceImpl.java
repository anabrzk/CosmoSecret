package users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import users.dao.TypeDao;
import users.model.Type;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    private TypeDao typeDao;

    public void setTypeDao(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    @Override
    @Transactional
    public void addType(Type type) {
        this.typeDao.addType(type);
    }

    @Override
    @Transactional
    public void updateType(Type type) {
this.typeDao.updateType(type);
    }

    @Override
    @Transactional
    public void removeType(int id) {
this.typeDao.removeType(id);
    }

    @Override
    @Transactional
    public Type getTypeById(int id) {
        return this.typeDao.getTypeById(id);
    }

    @Override
    @Transactional
    public List<Type> listType() {
        return this.typeDao.listType();
    }

    @Override
    @Transactional
    public List<Type> findTypeByName(String name) {
        List list = new ArrayList();
        for (Type type : this.typeDao.listType()) {
            if (type.getName().equals(name))
                list.add(type);
        }
        return list;
    }
}
