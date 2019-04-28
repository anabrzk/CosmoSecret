package users.dao;

import users.model.Care;

import java.util.List;

public interface CareDao {
    public void addCare(Care care);

    public void updateCare(Care care);

    public void removeCare(int id);

    public Care getCareById(int id);

    public List<Care> getCareByPrice(int price);

    public List<Care> listCare();

    public List<Care> listCareOrderAsc();

    public List<Care> listCareOrderDesc();
}