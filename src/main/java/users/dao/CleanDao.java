package users.dao;

import users.model.Clean;

import java.util.List;

public interface CleanDao {
    public void addClean(Clean clean);

    public void updateClean(Clean clean);

    public void removeClean(int id);

    public Clean getCleanById(int id);

    public List<Clean> getCleanByPrice(int price);

    public List<Clean> listClean();

    public List<Clean> listCleanOrderAsc();

    public List<Clean> listCleanOrderDesc();
}
