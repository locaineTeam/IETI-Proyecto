package com.project.api.service.impl;


import com.project.api.data.User;
import com.project.api.dto.UserDto;
import com.project.api.exception.UserException;
import com.project.api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    HashMap<String, User> map = new HashMap <String, User> ();


    public UserServiceImpl(){
        User user1=new User(new UserDto("Carlitos", "carlo@madri.com", "Nunez", "ayer",":)","me gusta el aguacate"));
        User user2=new User(new UserDto("Cesitar", "cesar@madri.com", "Vele","mañana",":(","buenas noches a todos"));
        map.put(user1.getId(), user1);
        map.put(user2.getId(), user2);

    }
    @Override
    public User create(User user) {

        map.put(user.getId(),user);
        return user;


    }


    @Override
    public User create(UserDto user) throws UserException {

        User newUser = new User(user);
        if(map.containsKey(newUser.getId())){
            throw new UserException("Este usuario ya existe.");
        }

        map.put(newUser.getId(),newUser);
        return newUser;

    }


    @Override
    public User findById(String id) throws UserException {
        User result = map.get(id);
        if(result==null){
            throw new UserException("Usuario no existe.");

        }

        return result;
    }

    @Override
    public List<User> all() {
        List<User> users = new ArrayList<>(map.values());
        return users;
    }

    @Override
    public User deleteById(String id) throws UserException {

        User userDelete = map.remove(id);
        if(userDelete==null){
            throw new UserException("Este Usuario no existe.");
        }
        return userDelete;


    }



    @Override
    public User update(UserDto user, String userId) throws UserException {
        User newUser = new User(user);
        User value = null;

        if(map.containsKey(userId)){
            value = map.get(userId);
            map.put(userId,newUser);
        }

        if(value == null){
            throw new UserException("Este Usuario no existe.");
        }
        return value;

    }
}
