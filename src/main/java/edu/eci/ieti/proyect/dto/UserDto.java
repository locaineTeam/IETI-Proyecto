package edu.eci.ieti.proyect.dto;

import edu.eci.ieti.proyect.entity.document.Genders;
import edu.eci.ieti.proyect.entity.document.Preferences;

import java.util.HashSet;

/**
 * The type User dto.
 */
public class UserDto {
  
    private String name;
    private String email;
    private String lastName;
    private String birthDay;
    private String foto;
    private String descripcion;
    private String password;
    private Preferences preferences;
    private Genders genero;
    private String universidad;

    //PRUEBA DATOS MATCH
    private HashSet<String> userRequests;
    private HashSet<String> userAccepts;


    /**
     * Instantiates a new User dto.
     */
    public UserDto() {
    }

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
     * @param genero      the genero
     * @param universidad the universidad
     */
    public UserDto(String name, String email, String lastName, String birthDay, String foto, String descripcion, String password, Genders genero, String universidad){

        this.name=name;
        this.email=email;
        this.lastName=lastName;
        this.birthDay = birthDay;
        this.foto = foto;
        this.descripcion = descripcion;
        this.password = password;
        this.genero=genero;
        this.universidad=universidad;

        //Match
        this.userRequests = new HashSet<>();
        this.userAccepts = new HashSet<>();

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

    /**
     * Gets Genero.
     *
     * @return the genero
     */
    public Genders getGenero() {
        return genero;
    }

    /**
     * Sets Genero.
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
     * Gets universidad.
     *
     * @param universidad the universidad
     */
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    /**
     * Gets preferences.
     *
     * @return the preferences
     */
    public Preferences getPreferences() {
        return preferences;
    }

    /**
     * Sets preferences.
     *
     * @param preferences the preferences
     */
    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
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
     * Gets all request.
     *
     * @return the all request
     */
    public HashSet<String> getUserRequests() {
        return userRequests;
    }

    /**
     * Sets all request.
     *
     * @param userRequests the all request
     */
    public void setUserRequests(HashSet<String> userRequests) {
        this.userRequests = userRequests;
    }

    /**
     * Gets all accepts.
     *
     * @return the all accepts
     */
    public HashSet<String> getUserAccepts() {
        return userAccepts;
    }

    /**
     * Sets all accepts.
     *
     * @param userAccepts the all accepts
     */
    public void setUserAccepts(HashSet<String> userAccepts) {
        this.userAccepts = userAccepts;
    }

    /**
     * Add user requests boolean.
     *
     * @param userId the user id
     * @return the boolean
     */
    public boolean addUserRequests(String userId){
        return this.userRequests.add(userId);
    }

    /**
     * Add user accepts boolean.
     *
     * @param userId the user id
     * @return the boolean
     */
    public boolean addUserAccepts(String userId){
        boolean flag = this.userRequests.contains(userId);
        if(flag){
            this.userRequests.remove(userId);
            flag = this.userAccepts.add(userId);
        }
        return flag;
    }

    /**
     * Delete user requests boolean.
     *
     * @param userId the user id
     * @return the boolean
     */
    public boolean deleteUserRequests(String userId){
        return this.userRequests.remove(userId);
    }


}
