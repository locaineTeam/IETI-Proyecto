package edu.eci.ieti.proyect.dto;

public class UserDto {
    private String name, email, lastName, birthDay, foto, descripcion;


    public UserDto(String name, String email, String lastName, String birthDay, String foto, String descripcion ){

        this.name=name;
        this.email=email;
        this.lastName=lastName;
        this.birthDay = birthDay;
        this.foto = foto;
        this.descripcion = descripcion;

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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
