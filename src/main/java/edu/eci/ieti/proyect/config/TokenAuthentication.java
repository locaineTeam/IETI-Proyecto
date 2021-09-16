package edu.eci.ieti.proyect.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Token authentication.
 */
public class TokenAuthentication
        extends AbstractAuthenticationToken
{
    /**
     * The Token.
     */
    String token;

    /**
     * The Subject.
     */
    String subject;

    /**
     * The Roles.
     */
    List<String> roles;

    /**
     * Instantiates a new Token authentication.
     *
     * @param token   the token
     * @param subject the subject
     * @param roles   the roles
     */
    public TokenAuthentication( String token, String subject, List<String> roles )
    {
        super( null );
        this.token = token;
        this.subject = subject;
        this.roles = roles;
    }

    @Override
    public boolean isAuthenticated()
    {
        return !token.isEmpty() && !subject.isEmpty() && !roles.isEmpty();
    }

    @Override
    public Object getCredentials()
    {
        return token;
    }

    @Override
    public Object getPrincipal()
    {
        return subject;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities()
    {
        return roles.stream().map( role -> new SimpleGrantedAuthority( "ROLE_" + role ) ).collect(
                Collectors.toList() );
    }


}