package edu.eci.ieti.proyect.controller.university;

import edu.eci.ieti.proyect.dto.UniversityDto;
import edu.eci.ieti.proyect.dto.UserDto;
import edu.eci.ieti.proyect.exception.UniversityException;
import edu.eci.ieti.proyect.exception.UserException;
import edu.eci.ieti.proyect.service.UniversityService;
import edu.eci.ieti.proyect.service.UserService;
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
@RequestMapping( "/v1/university" )
public class UniversityController {
    private final UniversityService universityService;
    /**
     * Instantiates a new User controller.
     *
     * @param universityService the user service
     */
    public UniversityController(@Autowired UniversityService universityService) {
        this.universityService=universityService;
    }

    /**
     * Create response entity.
     *
     * @param universityDto the user dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<?> create( @RequestBody UniversityDto universityDto )
    {
        try {
            return new ResponseEntity<>(universityService.create(universityDto),HttpStatus.CREATED);
        } catch (UniversityException e) {
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
            return new ResponseEntity<>(universityService.all(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }

    }
    /**
     * All Students response entity.
     *
     * @return the response entity
     */
    @GetMapping("/{nombre}/students")
    public ResponseEntity<?> allStudents(@PathVariable String nombre)
    {
        try{
            return new ResponseEntity<>(universityService.allStudents(nombre), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Se presenta un error", HttpStatus.BAD_REQUEST);
        }

    }
    /**
     * Find by name response entity.
     *
     * @param nombre the name
     * @return the response entity
     */
    @GetMapping("/{nombre}")
    public ResponseEntity<?> findByName(@PathVariable String nombre)
    {
        try{
            return new ResponseEntity<>(universityService.findByName(nombre), HttpStatus.OK);
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
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable String id )
    {
        try {
            return new ResponseEntity<>(universityService.findById(id),HttpStatus.OK);
        } catch (UniversityException e) {

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
            return new ResponseEntity<>(universityService.deleteById(id),HttpStatus.OK);
        } catch (UniversityException e) {
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }

    }

}
