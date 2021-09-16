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

@RestController
@RequestMapping( "/box/user" )
public class UserController {


    private final UserService userService;

    public UserController(@Autowired UserService userService )
    {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<User>> all()
    {

        return new ResponseEntity<>(userService.all(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id )
    {
        try {
            return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
        } catch (UserException e) {

            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<?> create( @RequestBody UserDto userDto )
    {
        try {
            return new ResponseEntity<>(userService.create(userDto),HttpStatus.CREATED);
        } catch (UserException e) {
            return new ResponseEntity<>(e,HttpStatus.FORBIDDEN);

        }
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<?> update(@RequestBody UserDto userDto, @PathVariable String id )
    {
        try {
            return new ResponseEntity<>(userService.update(userDto,id),HttpStatus.NO_CONTENT);
        } catch (UserException e) {
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }

    }

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
