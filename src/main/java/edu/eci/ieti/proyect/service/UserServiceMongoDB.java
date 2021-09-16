package edu.eci.ieti.proyect.service;

import edu.eci.ieti.proyect.dto.UserDto;
import edu.eci.ieti.proyect.entity.User;
import edu.eci.ieti.proyect.exception.UserException;
import edu.eci.ieti.proyect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceMongoDB implements UserService {
    private final UserRepository userRepository;

    public UserServiceMongoDB( @Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }
    @Override
    public User create(UserDto user) throws UserException {
        return userRepository.save(new User(user));
    }

    @Override
    public User findById(String id) throws UserException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UserException("Not Found");
        }
    }

    @Override
    public List<User> all() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) throws UserException {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User update(UserDto user, String userId) throws UserException {
        if(userRepository.findById(userId).isPresent()){
            User u = userRepository.findById(userId).get();
            u.update(user);
            userRepository.save(u);
            return u;
        }
        return null;
    }
}
