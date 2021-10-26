package edu.eci.ieti.proyect.dto;

import java.util.Date;

/**
 * The type Token dto.
 */
public class TokenDto {

    /**
     * The Token.
     */
    String token;
    /**
     * The Expiration date.
     */
    Date expirationDate;

    /**
     * Instantiates a new Token dto.
     *
     * @param token          the token
     * @param expirationDate the expiration date
     */
    public TokenDto( String token, Date expirationDate )
    {
        this.token = token;
        this.expirationDate = expirationDate;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken()
    {
        return token;
    }

    /**
     * Gets expiration date.
     *
     * @return the expiration date
     */
    public Date getExpirationDate()
    {
        return expirationDate;
    }
}
