package users.service;

import users.model.Lips;

import java.util.List;

public interface LipsService {
    public void addLips(Lips lips);

    public void updateLips(Lips lips);

    public void removeLips(int id);

    public Lips getLipsById(int id);

    public List<Lips> getLipsByPrice(int price);

    public List<Lips> listLips();

    public List<Lips> listLipsOrderAsc();

    public List<Lips> listLipsOrderDesc();

    public List<Lips> findLipsByName(String lipsName);

    public List<Lips> listLipsBrand();
}
