package users.service;

import users.model.Basket;

import java.util.List;

public interface BasketService {
    public void addBasket(Basket basket);

    public void updateBasket(int id);

    public void removeBasket(int id);

    public Basket getBasketById(int id);

    public List<Basket> listBasket();

    public List<Basket> findBasketByName(String basketName);


}
