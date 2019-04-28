package users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import users.dao.BrowsDao;
import users.model.Brows;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrowsServiceImpl implements BrowsService {

    private BrowsDao browsDao;

    public void setBrowsDao(BrowsDao browsDao) {
        this.browsDao = browsDao;
    }

    @Override
    @Transactional
    public void addBrows(Brows brows) {
        this.browsDao.addBrows(brows);
    }

    @Override
    @Transactional
    public void updateBrows(Brows brows) {
        this.browsDao.updateBrows(brows);
    }

    @Override
    @Transactional
    public void removeBrows(int id) {
        this.browsDao.removeBrows(id);
    }

    @Override
    @Transactional
    public Brows getBrowsById(int id) {
        return this.browsDao.getBrowsById(id);
    }

    @Override
    @Transactional
    public List<Brows> getBrowsByPrice(int price) {
        return this.browsDao.getBrowsByPrice(price);
    }

    @Override
    @Transactional
    public List<Brows> listBrows() {
        return this.browsDao.listBrows();
    }

    @Override
    @Transactional
    public List<Brows> listBrowsOrderAsc() {
        return this.browsDao.listBrowsOrderAsc();
    }

    @Override
    @Transactional
    public List<Brows> listBrowsOrderDesc() {
        return this.browsDao.listBrowsOrderDesc();
    }

    @Override
    @Transactional
    public List<Brows> findBrowsByName(String browsName) {
        List list = new ArrayList();
        for (Brows brows : this.browsDao.listBrows()) {
            if (brows.getBrand().equals(browsName))
                list.add(brows);
        }
        return list;
    }
}
