package edu.eci.ieti.proyect.service;




import edu.eci.ieti.proyect.dto.UserDto;
import edu.eci.ieti.proyect.entity.User;
import edu.eci.ieti.proyect.exception.UserException;

import java.util.List;

public interface UserService {

    User create(UserDto user ) throws UserException;

    User findById( String id ) throws UserException;

    List<User> all();

    boolean deleteById(String id ) throws UserException;

    //User update( User user, String userId ) throws UserException;
    User update( UserDto user, String userId ) throws UserException;
}