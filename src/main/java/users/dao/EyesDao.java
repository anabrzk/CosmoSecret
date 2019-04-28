package users.dao;

import users.model.Eyes;

import java.util.List;

public interface EyesDao {
    public void addEyes(Eyes eyes);

    public void updateEyes(Eyes eyes);

    public void removeEyes(int id);

    public Eyes getEyesById(int id);

    public List<Eyes> getEyesByPrice(int price);

    public List<Eyes> listEyes();

    public List<Eyes> listEyesOrderAsc();

    public List<Eyes> listEyesOrderDesc();
}
