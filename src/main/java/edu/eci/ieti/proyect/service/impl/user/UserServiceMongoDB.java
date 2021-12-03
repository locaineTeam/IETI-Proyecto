package edu.eci.ieti.proyect.service.impl.user;

import edu.eci.ieti.proyect.dto.UserDto;
import edu.eci.ieti.proyect.entity.User;
import edu.eci.ieti.proyect.entity.UserFacade;
import edu.eci.ieti.proyect.exception.UserException;
import edu.eci.ieti.proyect.repository.FacadeRopository;
import edu.eci.ieti.proyect.repository.UserRepository;
import edu.eci.ieti.proyect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB implements UserService {
    private final UserRepository userRepository;
    private final FacadeRopository facadeRopository;


    public UserServiceMongoDB( @Autowired UserRepository userRepository,@Autowired FacadeRopository facadeRopository )
    {
        this.facadeRopository=facadeRopository;
        this.userRepository = userRepository;
    }
    @Override
    public User create(UserDto user) throws UserException {
        User user1 = new User(user);
        user1 = userRepository.save(user1);
        System.out.println("USER ID: "+user1.getId());
        UserFacade u = new UserFacade("FakeNameStandar", "/photoStandar.jpg",user1.getId(),new ArrayList<String>(Arrays.asList("#FireBox")));
        facadeRopository.save(u);
        System.out.println("USER FACADE ID: "+u.getRealUserId());

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



}
