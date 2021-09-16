package com.project.api.service;



import com.project.api.data.User;
import com.project.api.dto.UserDto;
import com.project.api.exception.UserException;

import java.util.List;

public interface UserService {
    User create(User user );

    User create(UserDto user ) throws UserException;

    User findById( String id ) throws UserException;

    List<User> all();

    User deleteById(String id ) throws UserException;

    //User update( User user, String userId ) throws UserException;
    User update( UserDto user, String userId ) throws UserException;
}