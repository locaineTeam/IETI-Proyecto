package edu.eci.ieti.proyect.entity;

import edu.eci.ieti.proyect.dto.UserFacadeDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@Document
public class UserFacade {

    @Id
    private String realUserId;
    private String fakeName;
    private String photo;
    private ArrayList<String> hashTags;

    public UserFacade(){}

    public UserFacade(String fakeName, String photo, String realUserId, ArrayList<String> hashTags) {
        this.fakeName = fakeName;
        this.photo = photo;
        this.realUserId = realUserId;
        this.hashTags = hashTags;
    }

    public UserFacade(UserFacadeDto userFacadeDto) {
        this.fakeName = "nombre_aleatorio";
        this.photo = "foto_aleatoria";
        this.realUserId = userFacadeDto.getRealUserId();
        this.hashTags = userFacadeDto.getHashTags();
    }

    public String getFakeName() {
        return fakeName;
    }

    public void setFakeName(String fakeName) {
        this.fakeName = fakeName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRealUserId() {
        return realUserId;
    }

    public void setRealUserId(String realUserId) {
        this.realUserId = realUserId;
    }

    public ArrayList<String> getHashTags() {
        return hashTags;
    }

    public void setHashTags(ArrayList<String> hashTags) {
        this.hashTags = hashTags;
    }

    public void updateFacade(String fakeName, String photo, ArrayList<String> hashTags){
        this.fakeName = fakeName;
        this.photo = photo;
        this.hashTags = hashTags;
    }
}
