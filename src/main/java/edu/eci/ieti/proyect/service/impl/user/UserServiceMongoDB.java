package edu.eci.ieti.proyect.service.impl.user;

import edu.eci.ieti.proyect.dto.UserDto;
import edu.eci.ieti.proyect.entity.User;
import edu.eci.ieti.proyect.entity.UserFacade;
import edu.eci.ieti.proyect.exception.UserException;
import edu.eci.ieti.proyect.repository.FacadeRepository;
import edu.eci.ieti.proyect.repository.UserRepository;
import edu.eci.ieti.proyect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceMongoDB implements UserService {
    private final UserRepository userRepository;
    private final FacadeRepository facadeRepository;


    public UserServiceMongoDB( @Autowired UserRepository userRepository,@Autowired FacadeRepository facadeRepository)
    {
        this.facadeRepository = facadeRepository;
        this.userRepository = userRepository;
    }
    @Override
    public User create(UserDto user) throws UserException {
        User user1 = new User(user);
        user1 = userRepository.save(user1);
        UserFacade u = new UserFacade("FakeNameStandar", "/photoStandar.jpg",user1.getId(),new ArrayList<String>(Arrays.asList("#FireBox")));
        facadeRepository.save(u);

        return user1;

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

    @Override
    public User findByEmail(String email) throws UserException {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserException(UserException.USER_NOT_FOUND);
    }
    @Override
    public List<User> findByUniversidadGenero(String universidad, String genero)  {
        List<User> lista=userRepository.findByUniversidadAndAndGenero(universidad, genero);
        /*List<User> listaUniversidad=new ArrayList<User>();
        for (User u : lista){
            if(u.getGenero().equals(genero) && u.getUniversidad().equals(universidad)){
                listaUniversidad.add(u);
            }
        }*/
        return lista;
    }

    public List<User> findByUniversidad(String universidad)  {
        List<User> lista=userRepository.findByUniversidad(universidad);
        return lista;
    }

    //Match Services

    @Override
    public void addUserRequest(String userId, String userIdToAdd) throws UserException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent() || !userRepository.findById(userIdToAdd).isPresent()){
            throw new UserException(UserException.USER_NOT_FOUND);
        }
        User user = optionalUser.get();

        //Verify request is by a Friend
        if(user.getUserFriends().contains(userIdToAdd)){
            throw new UserException(UserException.USER_IS_ALREADY_FRIEND);
        }

        //Save actual Request List into DB
        user.getUserRequests().add(userIdToAdd);
        userRepository.save(user);
    }


    @Override
    public void deleteUserRequest(String userId, String userIdToDelete) throws UserException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent() || !userRepository.findById(userIdToDelete).isPresent()) {
            throw new UserException(UserException.USER_NOT_FOUND);
        }

        //Get user from Optional
        User user = optionalUser.get();

        //Remove userToDelete from UserRequest
        user.getUserRequests().remove(userIdToDelete);

        //Save actual Request List into DB
        userRepository.save(user);
    }

    @Override
    public void deleteUserFriend(String userId, String userIdToDelete) throws UserException {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<User> optionalUserToDelete = userRepository.findById(userIdToDelete);
        if(!optionalUser.isPresent() || !optionalUserToDelete.isPresent()) {
            throw new UserException(UserException.USER_NOT_FOUND);
        }

        //Get user from Optional
        User user = optionalUser.get();
        User userToDelete =  optionalUserToDelete.get();

        //remove both users to each other
        user.getUserFriends().remove(userIdToDelete);
        userToDelete.getUserFriends().remove(userId);

        //Save actual Request List and Friends List into DB
        userRepository.save(user);
        userRepository.save(userToDelete);
    }

    @Override
    public void addUserFriends(String userId, String userIdToAdd) throws UserException {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<User> optionalUserToAdd = userRepository.findById(userIdToAdd);
        if(!optionalUser.isPresent() || !optionalUserToAdd.isPresent()) {
            throw new UserException(UserException.USER_NOT_FOUND);
        }

        //Get user from Optional
        User user = optionalUser.get();

        //Verify if is already friend
        if(user.getUserFriends().contains(userIdToAdd)){
            throw new UserException(UserException.USER_IS_ALREADY_FRIEND);
        }

        //Verify if a request was sent before try to add as friend
        if(!user.getUserRequests().contains(userIdToAdd)){
            throw new UserException(UserException.USER_NO_IN_REQUEST);
        }
        User userToAdd =  optionalUserToAdd.get();

        //Remove users from UserRequest in case both send the request
        user.getUserRequests().remove(userIdToAdd);
        userToAdd.getUserRequests().remove(userId);

        //Add both users to each other
        user.getUserFriends().add(userIdToAdd);
        userToAdd.getUserFriends().add(userId);

        //Save actual Request List and Friends List into DB
        userRepository.save(user);
        userRepository.save(userToAdd);

    }

    @Override
    public HashSet<String> getAllRequestByUserId(String userId) throws UserException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new UserException(UserException.USER_NOT_FOUND);
        }
        return optionalUser.get().getUserRequests();
    }

    @Override
    public HashSet<String> getAllFriendsByUserId(String userId) throws UserException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new UserException(UserException.USER_NOT_FOUND);
        }
        return optionalUser.get().getUserFriends();
    }


    //End Match Services


}
