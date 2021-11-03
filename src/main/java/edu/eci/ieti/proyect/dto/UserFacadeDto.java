package edu.eci.ieti.proyect.dto;

import java.util.ArrayList;

public class UserFacadeDto {


    private String realUserId;
    private ArrayList<String> hashTags;
    private String photo,fakeName;


    public UserFacadeDto() {

    }
    public UserFacadeDto(String realUserId,String fakeName, String photo, ArrayList<String> hashTags) {
        this.realUserId = realUserId;
        this.hashTags = hashTags;
        this.photo = photo;
        this.fakeName = fakeName;

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFakeName() {
        return fakeName;
    }

    public void setFakeName(String fakeName) {
        this.fakeName = fakeName;
    }
}
