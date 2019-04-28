package users.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import users.dao.AntiageDao;
import users.model.Antiage;

import java.util.ArrayList;
import java.util.List;

@Service
public class AntiageServiceImpl implements AntiageService {

    private AntiageDao antiageDao;

    public void setAntiageDao(AntiageDao antiageDao) {
        this.antiageDao = antiageDao;
    }

    @Override
    @Transactional
    public void addAntiage(Antiage antiage) {
        this.antiageDao.addAntiage(antiage);
    }

    @Override
    @Transactional
    public void updateAntiage(Antiage antiage) {
        this.antiageDao.updateAntiage(antiage);
    }

    @Override
    @Transactional
    public void removeAntiage(int id) {
        this.antiageDao.removeAntiage(id);
    }

    @Override
    @Transactional
    public Antiage getAntiageById(int id) {
        return this.antiageDao.getAntiageById(id);
    }

    @Override
    @Transactional
    public List<Antiage> getAntiageByPrice(int price) {
        return this.antiageDao.getAntiageByPrice(price);
    }

    @Override
    @Transactional
    public List<Antiage> listAntiage() {
        return this.antiageDao.listAntiage();
    }

    @Override
    @Transactional
    public List<Antiage> listAntiageOrderAsc() {
        return this.antiageDao.listAntiageOrderAsc();
    }

    @Override
    @Transactional
    public List<Antiage> listAntiageOrderDesc() {
        return this.antiageDao.listAntiageOrderDesc();
    }

    @Override
    @Transactional
    public List<Antiage> findAntiageByName(String antiageName) {
        List list = new ArrayList();
        for (Antiage antiage : this.antiageDao.listAntiage()) {
            if (antiage.getBrand().equals(antiageName))
                list.add(antiage);
        }
        return list;
    }
}
