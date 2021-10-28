package edu.eci.ieti.proyect.entity;





import edu.eci.ieti.proyect.dto.UserDto;
import edu.eci.ieti.proyect.entity.document.Genders;
import edu.eci.ieti.proyect.entity.document.RoleEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type User.
 */
@Document
public class User {

    @Id
    private String id;
    private String name;
    @Indexed(unique=true)
    private String email;
    private String lastName;
    private String birthDate;
    /**
     * The Roles.
     */
    List<RoleEnum> roles;
    private String foto;
    private String descripcion;
    private String password;
    private Genders preferences;
    private Genders genero;
    private String universidad;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

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
     * @param genero      the genero
     * @param universidad the universidad
     */
    public User(String id, String name, String email, String lastName, String birthDate, String foto, String descripcion, String password, Genders genero, String universidad) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.foto = foto;
        this.descripcion = descripcion;
        this.roles = new ArrayList<>( Collections.singleton( RoleEnum.USER ) );
        this.password = BCrypt.hashpw( password, BCrypt.gensalt() );
        this.genero=genero;
        this.universidad=universidad;
    }

    /**
     * Instantiates a new User.
     *
     * @param id          the id
     * @param name        the name
     * @param email       the email
     * @param lastName    the last name
     * @param birthDate   the birth date
     * @param roles       the roles
     * @param foto        the foto
     * @param descripcion the descripcion
     * @param password    the password
     * @param preferences the preferences
     * @param genero      the genero
     * @param universidad the universidad
     */
    public User(String id, String name, String email, String lastName, String birthDate, List<RoleEnum> roles, String foto, String descripcion, String password, Genders preferences, Genders genero, String universidad) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.roles = roles;
        this.foto = foto;
        this.descripcion = descripcion;
        this.password = password;
        this.preferences = preferences;
        this.genero = genero;
        this.universidad = universidad;
    }

    /**
     * Instantiates a new User.
     *
     * @param user the user
     */
    public User(UserDto user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDay();
        this.foto = user.getFoto();
        this.descripcion = user.getDescripcion();
        this.roles = new ArrayList<>( Collections.singleton( RoleEnum.USER ) );
        this.password = BCrypt.hashpw( user.getPassword(), BCrypt.gensalt() );
        this.genero= user.getGenero();
        this.universidad=user.getUniversidad();

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

    /**
     * Gets genero.
     *
     * @return the genero
     */
    public Genders getGenero() {
        return genero;
    }

    /**
     * Sets genero.
     *
     * @param genero the genero
     */
    public void setGenero(Genders genero) {
        this.genero = genero;
    }

    /**
     * Gets universidad.
     *
     * @return the universidad
     */
    public String getUniversidad() {
        return universidad;
    }

    /**
     * Sets universidad.
     *
     * @param universidad the universidad
     */
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public List<RoleEnum> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
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

    public Genders getPreferences() {
        return preferences;
    }

    public void setPreferences(Genders preferences) {
        this.preferences = preferences;
    }

    /**
     * Update.
     *
     * @param userDto the user dto
     */
    public void update (UserDto userDto){
        this.name = userDto.getName();      
        this.lastName = userDto.getLastName();
        this.birthDate = userDto.getBirthDay();
        this.descripcion = userDto.getDescripcion();
        this.email = userDto.getEmail();
        this.foto = userDto.getFoto();
        this.password = BCrypt.hashpw( userDto.getPassword(), BCrypt.gensalt() );
        this.genero=userDto.getGenero();
        this.universidad= userDto.getUniversidad();
        this.preferences = userDto.getPreferences();
    }

   
}
