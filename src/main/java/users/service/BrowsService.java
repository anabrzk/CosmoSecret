package users.service;

import users.model.Brows;

import java.util.List;

public interface BrowsService {
    public void addBrows(Brows brows);

    public void updateBrows(Brows brows);

    public void removeBrows(int id);

    public Brows getBrowsById(int id);

    public List<Brows> getBrowsByPrice(int price);

    public List<Brows> listBrows();

    public List<Brows> listBrowsOrderAsc();

    public List<Brows> listBrowsOrderDesc();

    public List<Brows> findBrowsByName(String browsName);
}