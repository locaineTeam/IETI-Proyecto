package edu.eci.ieti.proyect.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * The type Security configuration.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity( securedEnabled = true, jsr250Enabled = true, prePostEnabled = true )
public class SecurityConfiguration
        extends WebSecurityConfigurerAdapter
{

    /**
     * The Jwt request filter.
     */
    JwtRequestFilter jwtRequestFilter;

    /**
     * Instantiates a new Security configuration.
     *
     * @param jwtRequestFilter the jwt request filter
     */
    public SecurityConfiguration( @Autowired JwtRequestFilter jwtRequestFilter )
    {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Override
    protected void configure( HttpSecurity http )
            throws Exception
    {
        http.addFilterBefore( jwtRequestFilter, BasicAuthenticationFilter.class )
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/v1/works" ).permitAll()
                .antMatchers( HttpMethod.POST,"/v1/auth" ).permitAll()
                .antMatchers( HttpMethod.POST,"/box/user" ).permitAll()
                .antMatchers( HttpMethod.GET,"/box/user" ).permitAll()
                .anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS );
    }
}