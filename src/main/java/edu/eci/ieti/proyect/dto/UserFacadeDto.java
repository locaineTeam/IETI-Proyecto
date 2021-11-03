package edu.eci.ieti.proyect.dto;

import java.util.ArrayList;

public class UserFacadeDto {


    private String realUserId;
    private ArrayList<String> hashTags;

    public UserFacadeDto(String realUserId, ArrayList<String> hashTags) {
        this.realUserId = realUserId;
        this.hashTags = hashTags;
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
}
