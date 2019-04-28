package users.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import users.dao.LipsDao;
import users.model.Lips;

import java.util.ArrayList;
import java.util.List;

@Service
public class LipsServiceImpl implements LipsService {

    private LipsDao lipsDao;

    public void setLipsDao(LipsDao lipsDao) {
        this.lipsDao = lipsDao;
    }

    @Override
    @Transactional
    public void addLips(Lips lips) {
        this.lipsDao.addLips(lips);
    }

    @Override
    @Transactional
    public void updateLips(Lips lips) {
        this.lipsDao.updateLips(lips);
    }

    @Override
    @Transactional
    public void removeLips(int id) {
        this.lipsDao.removeLips(id);
    }

    @Override
    @Transactional
    public Lips getLipsById(int id) {
        return this.lipsDao.getLipsById(id);
    }

    @Override
    @Transactional
    public List<Lips> getLipsByPrice(int price) {
        return this.lipsDao.getLipsByPrice(price);
    }

    @Override
    @Transactional
    public List<Lips> listLips() {
        return this.lipsDao.listLips();
    }

    @Override
    @Transactional
    public List<Lips> listLipsOrderAsc() {
        return this.lipsDao.listLipsOrderAsc();
    }

    @Override
    @Transactional
    public List<Lips> listLipsOrderDesc() {
        return this.lipsDao.listLipsOrderDesc();
    }

    @Override
    @Transactional
    public List<Lips> findLipsByName(String lipsName) {
        List list = new ArrayList();
        for (Lips lips : this.lipsDao.listLips()) {
            if (lips.getBrand().equals(lipsName))
                list.add(lips);
        }
        return list;
    }

    @Override
    @Transactional
    public List<Lips> listLipsBrand() {
        return this.lipsDao.listLipsBrand();
    }

}
