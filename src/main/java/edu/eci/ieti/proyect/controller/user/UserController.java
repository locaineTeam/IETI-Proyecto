package edu.eci.ieti.proyect.controller.user;



import edu.eci.ieti.proyect.dto.UserDto;
import edu.eci.ieti.proyect.entity.User;
import edu.eci.ieti.proyect.exception.UserException;
import edu.eci.ieti.proyect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type User controller.
 */
@RestController
@RequestMapping( "/box/user" )
public class UserController {


    private final UserService userService;

    /**
     * Instantiates a new User controller.
     *
     * @param userService the user service
     */
    public UserController(@Autowired UserService userService )
    {
        this.userService = userService;
    }


    /**
     * All response entity.
     *
     * @return the response entity
     */
    @GetMapping
    public ResponseEntity<List<User>> all()
    {

        return new ResponseEntity<>(userService.all(), HttpStatus.OK);

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
            return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
        } catch (UserException e) {

            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Create response entity.
     *
     * @param userDto the user dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<?> create( @RequestBody UserDto userDto )
    {
        try {
            return new ResponseEntity<>(userService.create(userDto),HttpStatus.CREATED);
        } catch (UserException e) {
            return new ResponseEntity<>(e,HttpStatus.FORBIDDEN);

        }
    }

    /**
     * Update response entity.
     *
     * @param userDto the user dto
     * @param id      the id
     * @return the response entity
     */
    @PutMapping( "/{id}" )
    public ResponseEntity<?> update(@RequestBody UserDto userDto, @PathVariable String id )
    {
        try {
            return new ResponseEntity<>(userService.update(userDto,id),HttpStatus.NO_CONTENT);
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
    public ResponseEntity<?> delete( @PathVariable String id )
    {
        try {
            return new ResponseEntity<>(userService.deleteById(id),HttpStatus.OK);
        } catch (UserException e) {
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }

    }


}