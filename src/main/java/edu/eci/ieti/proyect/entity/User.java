package edu.eci.ieti.proyect.entity;





import edu.eci.ieti.proyect.dto.UserDto;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.security.Timestamp;
import java.util.UUID;

/**
 * The type User.
 */
public class User {

    private String id, name, email, lastName, birthDate, foto, descripcion, password;


    /**
     * Instantiates a new User.
     *
     * @param id          the id
     * @param name        the name
     * @param email       the email
     * @param lastName    the last name
     * @param birthDate   the birth date
     * @param foto        the foto
     * @param descripcion the descripcion
     * @param password    the password
     */
    public User(String id, String name, String email, String lastName, String birthDate, String foto, String descripcion, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.foto = foto;
        this.descripcion = descripcion;
        this.password = password;
    }

    /**
     * Instantiates a new User.
     *
     * @param user the user
     */
    public User(UserDto user) {
        this.id = UUID.randomUUID().toString();
        this.name = user.getName();
        this.email = user.getEmail();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDay();
        this.foto = user.getFoto();
        this.descripcion = user.getDescripcion();
        this.password = BCrypt.hashpw( user.getPassword(), BCrypt.gensalt() );

    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
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
     * Gets birth date.
     *
     * @return the birth date
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets birth date.
     *
     * @param birthDate the birth date
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
