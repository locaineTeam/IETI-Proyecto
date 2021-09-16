package edu.eci.ieti.proyect.entity;


import java.util.Date;

/**
 * The type Token.
 */
public class Token {

    /**
     * The Id user.
     */
    String IdUser;
    /**
     * The Token.
     */
    String token;
    /**
     * The Expiration date.
     */
    Date expirationDate;

    /**
     * Instantiates a new Token.
     *
     * @param idUser         the id user
     * @param token          the token
     * @param expirationDate the expiration date
     */
    public Token(String idUser, String token, Date expirationDate) {
        IdUser = idUser;
        this.token = token;
        this.expirationDate = expirationDate;
    }

    /**
     * Gets id user.
     *
     * @return the id user
     */
    public String getIdUser() {
        return IdUser;
    }

    /**
     * Sets id user.
     *
     * @param idUser the id user
     */
    public void setIdUser(String idUser) {
        IdUser = idUser;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Gets expiration date.
     *
     * @return the expiration date
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets expiration date.
     *
     * @param expirationDate the expiration date
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
