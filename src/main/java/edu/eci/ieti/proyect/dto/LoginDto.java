package edu.eci.ieti.proyect.dto;

/**
 * The type Login dto.
 */
public class LoginDto {
    /**
     * The Email.
     */
    String email;

    /**
     * The Password.
     */
    String password;

    /**
     * Instantiates a new Login dto.
     *
     * @param email    the email
     * @param password the password
     */
    public LoginDto( String email, String password )
    {
        this.email = email;
        this.password = password;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }
}
