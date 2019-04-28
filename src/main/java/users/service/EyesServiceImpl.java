package users.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import users.dao.EyesDao;
import users.model.Eyes;

import java.util.ArrayList;
import java.util.List;

@Service
public class EyesServiceImpl implements EyesService {

    private EyesDao eyesDao;

    public void setEyesDao(EyesDao eyesDao) {
        this.eyesDao = eyesDao;
    }

    @Override
    @Transactional
    public void addEyes(Eyes eyes) {
        this.eyesDao.addEyes(eyes);
    }

    @Override
    @Transactional
    public void updateEyes(Eyes eyes) {
        this.eyesDao.updateEyes(eyes);
    }

    @Override
    @Transactional
    public void removeEyes(int id) {
        this.eyesDao.removeEyes(id);
    }

    @Override
    @Transactional
    public Eyes getEyesById(int id) {
        return this.eyesDao.getEyesById(id);
    }

    @Override
    @Transactional
    public List<Eyes> getEyesByPrice(int price) {
        return this.eyesDao.getEyesByPrice(price);
    }

    @Override
    @Transactional
    public List<Eyes> listEyes() {
        return this.eyesDao.listEyes();
    }

    @Override
    @Transactional
    public List<Eyes> listEyesOrderAsc() {
        return this.eyesDao.listEyesOrderAsc();
    }

    @Override
    @Transactional
    public List<Eyes> listEyesOrderDesc() {
        return this.eyesDao.listEyesOrderDesc();
    }

    @Override
    @Transactional
    public List<Eyes> findEyesByName(String eyesName) {
        List list = new ArrayList();
        for (Eyes eyes : this.eyesDao.listEyes()) {
            if (eyes.getBrand().equals(eyesName))
                list.add(eyes);
        }
        return list;
    }
}
