package users.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import users.dao.CleanDao;
import users.model.Clean;

import java.util.ArrayList;
import java.util.List;

@Service
public class CleanServiceImpl implements CleanService {

    private CleanDao cleanDao;

    public void setCleanDao(CleanDao cleanDao) {
        this.cleanDao = cleanDao;
    }

    @Override
    @Transactional
    public void addClean(Clean clean) {
        this.cleanDao.addClean(clean);
    }

    @Override
    @Transactional
    public void updateClean(Clean clean) {
        this.cleanDao.updateClean(clean);
    }

    @Override
    @Transactional
    public void removeClean(int id) {
        this.cleanDao.removeClean(id);
    }

    @Override
    @Transactional
    public Clean getCleanById(int id) {
        return this.cleanDao.getCleanById(id);
    }

    @Override
    @Transactional
    public List<Clean> getCleanByPrice(int price) {
        return this.cleanDao.getCleanByPrice(price);
    }

    @Override
    @Transactional
    public List<Clean> listClean() {
        return this.cleanDao.listClean();
    }

    @Override
    @Transactional
    public List<Clean> listCleanOrderAsc() {
        return this.cleanDao.listCleanOrderAsc();
    }

    @Override
    @Transactional
    public List<Clean> listCleanOrderDesc() {
        return this.cleanDao.listCleanOrderDesc();
    }

    @Override
    @Transactional
    public List<Clean> findCleanByName(String cleanName) {
        List list = new ArrayList();
        for (Clean clean : this.cleanDao.listClean()) {
            if (clean.getBrand().equals(cleanName))
                list.add(clean);
        }
        return list;
    }
}
