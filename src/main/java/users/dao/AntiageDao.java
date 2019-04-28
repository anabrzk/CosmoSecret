package users.dao;

import users.model.Antiage;

import java.util.List;

public interface AntiageDao {
    public void addAntiage(Antiage antiage);

    public void updateAntiage(Antiage antiage);

    public void removeAntiage(int id);

    public Antiage getAntiageById(int id);

    public List<Antiage> getAntiageByPrice(int price);

    public List<Antiage> listAntiage();

    public List<Antiage> listAntiageOrderAsc();

    public List<Antiage> listAntiageOrderDesc();
}
