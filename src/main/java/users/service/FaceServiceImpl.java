package users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import users.dao.FaceDao;
import users.model.Face;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaceServiceImpl implements FaceService {

    private FaceDao faceDao;

    public void setFaceDao(FaceDao faceDao) {
        this.faceDao = faceDao;
    }

    @Override
    @Transactional
    public void addFace(Face face) {
        this.faceDao.addFace(face);
    }

    @Override
    @Transactional
    public void updateFace(Face face) {
        this.faceDao.updateFace(face);
    }

    @Override
    @Transactional
    public void removeFace(int id) {
        this.faceDao.removeFace(id);
    }

    @Override
    @Transactional
    public Face getFaceById(int id) {
        return this.faceDao.getFaceById(id);
    }

    @Override
    @Transactional
    public List<Face> listFace() {
        return this.faceDao.listFace();
    }

    @Override
    @Transactional
    public List<Face> findFaceByName(String name) {
        List list = new ArrayList();
        for (Face face : this.faceDao.listFace()) {
            if (face.getBrand().equals(name))
                list.add(face);
        }
        return list;
    }

    @Override
    @Transactional
    public List<Face> getFaceByPrice(int price) {
        return this.faceDao.getFaceByPrice(price);
    }

    @Override
    @Transactional
    public List<Face> listFaceOrderAsc() {
        return this.faceDao.listFaceOrderAsc();
    }

    @Override
    @Transactional
    public List<Face> listFaceOrderDesc() {
        return this.faceDao.listFaceOrderDesc();
    }




}
