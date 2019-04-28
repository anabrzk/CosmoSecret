package users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import users.dao.BasketDao;
import users.dao.FaceDao;
import users.model.Basket;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {

    private BasketDao basketDao;

    public void setBasketDao(BasketDao basketDao) {
        this.basketDao = basketDao;
    }


    @Override
    @Transactional
    public void addBasket(Basket basket) {
        this.basketDao.addBasket(basket);
    }

    @Override
    @Transactional
    public void updateBasket(int id) {
        this.basketDao.updateBasket(id);
    }

    @Override
    @Transactional
    public void removeBasket(int id) {
        this.basketDao.removeBasket(id);
    }

    @Override
    @Transactional
    public Basket getBasketById(int id) {
        return this.basketDao.getBasketById(id);
    }

    @Override
    @Transactional
    public List<Basket> listBasket() {
        return this.basketDao.listBasket();
    }

    @Override
    @Transactional
    public List<Basket> findBasketByName(String basketName) {
        List list = new ArrayList();
        for (Basket basket : this.basketDao.listBasket()) {
            if (basket.getColor().equals(basketName))
                list.add(basket);
        }
        return list;
    }





}
