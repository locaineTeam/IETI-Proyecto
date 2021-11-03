package edu.eci.ieti.proyect.controller.user;

import edu.eci.ieti.proyect.dto.UserFacadeDto;
import edu.eci.ieti.proyect.service.UserFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.ieti.proyect.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;

/**
 * The type User controller.
 */
@RestController
@RequestMapping( "/v1/userFacade" )
public class UserFacadeController {

    private final UserFacadeService userFacadeService;

    /**
     * Instantiates a new User controller.
     *
     * @param userFacadeService the user service
     */
     public UserFacadeController(@Autowired UserFacadeService userFacadeService) {
        this.userFacadeService = userFacadeService;
    }
    /**
     * Create response entity.
     *
     * @param UserFacadto the userFacade dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserFacadeDto UserFacadto )
    {
        try {
            return new ResponseEntity<>(userFacadeService.create(UserFacadto),HttpStatus.CREATED);
        } catch (UserException e) {
            return new ResponseEntity<>(e,HttpStatus.FORBIDDEN);

        }
    }

    /**
     * All response entity.
     *
     * @return the response entity
     */
    @GetMapping()
    public ResponseEntity<?> all()
    {
        try{
            return new ResponseEntity<>(userFacadeService.all(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Se presenta un error", HttpStatus.BAD_REQUEST);
        }

    }
    /**
     * Find by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id )
    {
        try {
            return new ResponseEntity<>(userFacadeService.findByRealId(id),HttpStatus.OK);
        } catch (UserException e) {

            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update response entity.
     *

     * @param id      the userRealId
     * @return the response entity
     */
    @PutMapping( "/{id}" )
    public ResponseEntity<?> update(@PathVariable String id,@RequestBody UserFacadeDto userFacadeDto)
    {
        try {
            return new ResponseEntity<>(userFacadeService.update(userFacadeDto),HttpStatus.NO_CONTENT);
        } catch (UserException e) {
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }

    }

    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping( "/{id}" )
    @RolesAllowed("ADMIN")
    public ResponseEntity<?> delete( @PathVariable String id )
    {
        try {
            return new ResponseEntity<>(userFacadeService.deleteByRealId(id),HttpStatus.OK);
        } catch (UserException e) {
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }

    }



}
