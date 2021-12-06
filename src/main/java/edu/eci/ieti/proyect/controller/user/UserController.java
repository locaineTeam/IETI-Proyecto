package edu.eci.ieti.proyect.controller.user;



import edu.eci.ieti.proyect.dto.UserDto;
import edu.eci.ieti.proyect.entity.document.Genders;
import edu.eci.ieti.proyect.entity.document.Preferences;
import edu.eci.ieti.proyect.exception.UserException;
import edu.eci.ieti.proyect.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

/**
 * The type User controller.
 */
@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping( "/v1/user" )
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
    @GetMapping()
    public ResponseEntity<?> all()
    {
        try{
            return new ResponseEntity<>(userService.all(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Se presenta un error", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/some")
    public ResponseEntity<?> findSomeById(@RequestBody List<String> usersId)
    {
        try{
            return new ResponseEntity<>(userService.findSomeById(usersId), HttpStatus.OK);
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
            return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
        } catch (UserException e) {

            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Find by id response entity.
     *
     * @param email the email
     * @return the response entity
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email )
    {
        try {
            return new ResponseEntity<>(userService.findByEmail(email),HttpStatus.OK);
        } catch (UserException e) {

            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/university/{universidad}/{genero}")
    public ResponseEntity<?> findByUniGen(@PathVariable String universidad,@PathVariable String genero )
    {
        return new ResponseEntity<>(userService.findByUniversidadGenero(universidad,genero),HttpStatus.OK);
    }

    @GetMapping("/university/{universidad}")
    public ResponseEntity<?> findByUni(@PathVariable String universidad)
    {
        return new ResponseEntity<>(userService.findByUniversidad(universidad),HttpStatus.OK);
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
            return new ResponseEntity<>(userService.update(userDto,id),HttpStatus.OK);
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
            return new ResponseEntity<>(userService.deleteById(id),HttpStatus.OK);
        } catch (UserException e) {
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/genders")
    public ResponseEntity<?> findAllGenders()
    {
        return new ResponseEntity<>(Genders.values(),HttpStatus.OK);
    }

    @GetMapping("/preferences")
    public ResponseEntity<?> findAllPreferences()
    {
        return new ResponseEntity<>(Preferences.values(),HttpStatus.OK);
    }


    //Match Endpoints

    @GetMapping("/{userId}/request")
    public ResponseEntity<?> findAllRequest(@PathVariable String userId){
        try{
            return new ResponseEntity<>(userService.getAllRequestByUserId(userId),HttpStatus.OK);
        } catch (UserException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{userId}/friends")
    public ResponseEntity<?> findAllFriends(@PathVariable String userId){
        try{
            return new ResponseEntity<>(userService.getAllFriendsByUserId(userId),HttpStatus.OK);
        } catch (UserException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/{userId}/request")
    public ResponseEntity<?> addNewRequest(@PathVariable String userId, @RequestBody String userIdToAdd){
        try{
            userService.addUserRequest(userId, userIdToAdd);
            return new ResponseEntity<>("User Added to Request",HttpStatus.CREATED);
        }catch(UserException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{userId}/friends")
    public ResponseEntity<?> addNewFriend(@PathVariable String userId, @RequestBody String userIdToAdd){
        try{
            userService.addUserFriends(userId, userIdToAdd);
            return new ResponseEntity<>("User Added to Friends",HttpStatus.CREATED);
        }catch(UserException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{userId}/request/{userToDelete}")
    public ResponseEntity<?> delRequest(@PathVariable String userId, @PathVariable String userToDelete){
        try{
            userService.deleteUserRequest(userId, userToDelete);
            return new ResponseEntity<>("User Deleted from Request",HttpStatus.CREATED);
        }catch(UserException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{userId}/friends/{userToDelete}")
    public ResponseEntity<?> delFriend(@PathVariable String userId, @PathVariable String userToDelete){
        try{
            userService.deleteUserFriend(userId, userToDelete);
            return new ResponseEntity<>("User Deleted from Friends",HttpStatus.CREATED);
        }catch(UserException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }



    //End Match Endpoints


}
