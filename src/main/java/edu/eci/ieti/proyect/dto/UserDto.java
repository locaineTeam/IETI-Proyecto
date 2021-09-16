package edu.eci.ieti.proyect.dto;

/**
 * The type User dto.
 */
public class UserDto {
  
    private String name, email, lastName, birthDay, foto, descripcion, password;


    /**
     * Instantiates a new User dto.
     *
     * @param name        the name
     * @param email       the email
     * @param lastName    the last name
     * @param birthDay    the birth day
     * @param foto        the foto
     * @param descripcion the descripcion
     * @param password    the password
     */
    public UserDto(String name, String email, String lastName, String birthDay, String foto, String descripcion, String password ){

        this.name=name;
        this.email=email;
        this.lastName=lastName;
        this.birthDay = birthDay;
        this.foto = foto;
        this.descripcion = descripcion;
        this.password = password;

    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets birth day.
     *
     * @return the birth day
     */
    public String getBirthDay() {
        return birthDay;
    }

    /**
     * Sets birth day.
     *
     * @param birthDay the birth day
     */
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * Gets foto.
     *
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Sets foto.
     *
     * @param foto the foto
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Gets descripcion.
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets descripcion.
     *
     * @param descripcion the descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}
