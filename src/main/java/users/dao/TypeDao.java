package users.dao;

import users.model.Type;

import java.util.List;

public interface TypeDao {
    public void addType(Type type);

    public void updateType(Type type);

    public void removeType(int id);

    public Type getTypeById(int id);

    public List<Type> listType();

}
