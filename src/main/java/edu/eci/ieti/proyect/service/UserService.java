package edu.eci.ieti.proyect.service;




import edu.eci.ieti.proyect.dto.UserDto;
import edu.eci.ieti.proyect.entity.User;
import edu.eci.ieti.proyect.exception.UserException;

import java.util.HashSet;
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

    List<User>findByUniversidadGenero(String universidad,String genero) ;

    List<User> findByUniversidad(String universidad);


    void addUserRequest(String userId, String userIdToAdd) throws UserException;

    void deleteUserRequest(String userId, String userIdToDelete) throws UserException;

    void deleteUserFriend(String userId, String userIdToDelete) throws UserException;

    void addUserFriends(String userId, String userIdToAdd) throws UserException;

    HashSet<String> getAllRequestByUserId(String userId) throws UserException;

    HashSet<String> getAllFriendsByUserId(String userId) throws UserException;
    
    List<User> findSomeById(List<String> usersId) throws UserException;

}