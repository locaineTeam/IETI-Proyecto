package edu.eci.ieti.proyect.service;




import edu.eci.ieti.proyect.dto.UserDto;
import edu.eci.ieti.proyect.entity.User;
import edu.eci.ieti.proyect.exception.UserException;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Create user.
     *
     * @param user the user
     * @return the user
     * @throws UserException the user exception
     */
    User create(UserDto user ) throws UserException;

    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     * @throws UserException the user exception
     */
    User findById( String id ) throws UserException;

    /**
     * All list.
     *
     * @return the list
     */
    List<User> all();

    /**
     * Delete by id user.
     *
     * @param id the id
     * @return the boolean value to delete successfully
     * @throws UserException the user exception
     */
    boolean deleteById(String id ) throws UserException;

    /**
     * Update user.
     *
     * @param user   the user
     * @param userId the user id
     * @return the user
     * @throws UserException the user exception
     */
//User update( User user, String userId ) throws UserException;
    User update( UserDto user, String userId ) throws UserException;

    /**
     * Find by email user.
     *
     * @param email the email
     * @return the user
     * @throws UserException the user exception
     */
    User findByEmail(String email) throws UserException;
}