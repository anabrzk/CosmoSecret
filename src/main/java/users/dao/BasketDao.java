package users.dao;

import users.model.Basket;

import java.util.List;

public interface BasketDao {
    public void addBasket(Basket basket);

    public void updateBasket(int id);

    public void removeBasket(int id);

    public Basket getBasketById(int id);

    public List<Basket> listBasket();
}
