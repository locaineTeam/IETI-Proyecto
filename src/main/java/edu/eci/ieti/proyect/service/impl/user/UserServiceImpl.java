package edu.eci.ieti.proyect.service.impl.user;



import edu.eci.ieti.proyect.dto.UserDto;
import edu.eci.ieti.proyect.entity.User;
import edu.eci.ieti.proyect.entity.document.Genders;
import edu.eci.ieti.proyect.exception.UserException;
import edu.eci.ieti.proyect.service.UserService;

import java.util.*;
import java.util.stream.Collectors;


/**
 * The type User service.
 */

public class UserServiceImpl implements UserService {

    /**
     * The Map.
     */
    HashMap<String, User> map = new HashMap <String, User> ();


    /**
     * Instantiates a new User service.
     */
    public UserServiceImpl(){
        User user1=new User(new UserDto("Carlitos", "carlo@madri.com", "Nunez", "ayer",":)","me gusta el aguacate","123", Genders.Hombre,"eci"));
        User user2=new User(new UserDto("Cesitar", "cesar@madri.com", "Vele","mañana",":(","buenas noches a todos","123", Genders.Hombre,"eci"));
        map.put(user1.getId(), user1);
        map.put(user2.getId(), user2);

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
    public boolean deleteById(String id) throws UserException {

        User userDelete = map.remove(id);
        if(userDelete==null){
            throw new UserException("Este Usuario no existe.");
        }
        return true;


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

    @Override
    public User findByEmail(String email) throws UserException {

        List<User> users = map.values()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .collect(Collectors.toList());
        if(users.isEmpty()){
            throw new UserException("");
        }

        return null;
    }

    @Override
    public List<User> findByUniversidadGenero(String universidad, String genero) {
        return null;
    }

    @Override
    public List<User> findByUniversidad(String universidad) {
        return null;
    }




}
