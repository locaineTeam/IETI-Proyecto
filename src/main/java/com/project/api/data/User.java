package com.project.api.data;



import com.project.api.dto.UserDto;

import java.security.Timestamp;
import java.util.UUID;

public class User {

    private String id, name, email, lastName, birthDate;


    public User(String id, String name, String email, String lastName, String birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public User(UserDto user) {
        this.id = UUID.randomUUID().toString();
        this.name = user.getName();
        this.email = user.getEmail();
        this.lastName = user.getLastName();
        this.birthDate = null;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
