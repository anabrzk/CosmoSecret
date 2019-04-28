package users.service;

import users.model.Face;

import java.util.List;

public interface FaceService {
    public void addFace(Face face);

    public void updateFace(Face face);

    public void removeFace(int id);

    public Face getFaceById(int id);

    public List<Face> listFace();

    public List<Face> findFaceByName(String faceName);

    public List<Face> getFaceByPrice(int price);

    public List<Face> listFaceOrderAsc();

    public List<Face> listFaceOrderDesc();


}

