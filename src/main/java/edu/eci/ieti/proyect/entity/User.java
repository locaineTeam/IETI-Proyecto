package edu.eci.ieti.proyect.entity;





import edu.eci.ieti.proyect.dto.UserDto;

import java.security.Timestamp;
import java.util.UUID;

public class User {

    private String id, name, email, lastName, birthDate, foto, descripcion;


    public User(String id, String name, String email, String lastName, String birthDate, String foto, String descripcion ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.foto = foto;
        this.descripcion = descripcion;
    }

    public User(UserDto user) {
        this.id = UUID.randomUUID().toString();
        this.name = user.getName();
        this.email = user.getEmail();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDay();
        this.foto = user.getFoto();
        this.descripcion = user.getDescripcion();

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
