package edu.eci.ieti.proyect.controller.auth;

import edu.eci.ieti.proyect.dto.LoginDto;
import edu.eci.ieti.proyect.dto.TokenDto;
import edu.eci.ieti.proyect.entity.User;
import edu.eci.ieti.proyect.exception.UserException;
import edu.eci.ieti.proyect.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

import static edu.eci.ieti.proyect.util.Constants.CLAIMS_ROLES_KEY;
import static edu.eci.ieti.proyect.util.Constants.TOKEN_DURATION_MINUTES;


/**
 * The type Auth controller.
 */
@RestController
@RequestMapping( "v1/auth")
public class AuthController {

    @Value( "${app.secret}" )
    private String secret;
    private final UserService userService;

    /**
     * Instantiates a new Auth controller.
     *
     * @param userService the user service
     */
    public AuthController( @Autowired UserService userService )
    {
        this.userService = userService;
    }

    /**
     * Login token dto.
     *
     * @param loginDto the login dto
     * @return the token dto
     * @throws UserException the user exception
     */
    @PostMapping
    public TokenDto login( @RequestBody LoginDto loginDto ) throws UserException {

        User user = null;
        try {
            user = userService.findByEmail( loginDto.getEmail() );
        } catch (UserException e) {
            e.printStackTrace();
        }
        assert user != null;
        if ( BCrypt.checkpw( loginDto.getPassword(), user.getPassword() ) )
        {
            return generateTokenDto( user );
        }
        else
        {
            throw new UserException("Error");
        }

    }

    private String generateToken( User user, Date expirationDate )
    {
        return Jwts.builder()
                .setSubject( user.getId() )
                .claim( CLAIMS_ROLES_KEY, user.getRoles())
                .setIssuedAt(new Date() )
                .setExpiration( expirationDate )
                .signWith( SignatureAlgorithm.HS256, secret )
                .compact();
    }

    private TokenDto generateTokenDto(User user )
    {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add( Calendar.MINUTE, TOKEN_DURATION_MINUTES );
        String token = generateToken( user, expirationDate.getTime() );
        return new TokenDto( token, expirationDate.getTime() );
    }



}
