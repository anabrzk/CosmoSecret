package users.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import users.dao.CareDao;
import users.model.Care;

import java.util.ArrayList;
import java.util.List;

@Service
public class CareServiceImpl implements CareService {

    private CareDao careDao;

    public void setCareDao(CareDao careDao) {
        this.careDao = careDao;
    }

    @Override
    @Transactional
    public void addCare(Care care) {
        this.careDao.addCare(care);
    }

    @Override
    @Transactional
    public void updateCare(Care care) {
        this.careDao.updateCare(care);
    }

    @Override
    @Transactional
    public void removeCare(int id) {
        this.careDao.removeCare(id);
    }

    @Override
    @Transactional
    public Care getCareById(int id) {
        return this.careDao.getCareById(id);
    }

    @Override
    @Transactional
    public List<Care> getCareByPrice(int price) {
        return this.careDao.getCareByPrice(price);
    }

    @Override
    @Transactional
    public List<Care> listCare() {
        return this.careDao.listCare();
    }

    @Override
    @Transactional
    public List<Care> listCareOrderAsc() {
        return this.careDao.listCareOrderAsc();
    }

    @Override
    @Transactional
    public List<Care> listCareOrderDesc() {
        return this.careDao.listCareOrderDesc();
    }

    @Override
    @Transactional
    public List<Care> findCareByName(String careName) {
        List list = new ArrayList();
        for (Care care : this.careDao.listCare()) {
            if (care.getBrand().equals(careName))
                list.add(care);
        }
        return list;
    }
}
