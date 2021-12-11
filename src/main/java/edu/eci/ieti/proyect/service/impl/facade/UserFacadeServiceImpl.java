
package edu.eci.ieti.proyect.service.impl.facade;

import edu.eci.ieti.proyect.dto.UserFacadeDto;
import edu.eci.ieti.proyect.entity.UserFacade;
import edu.eci.ieti.proyect.exception.UserException;
import edu.eci.ieti.proyect.repository.FacadeRepository;
import edu.eci.ieti.proyect.service.UserFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserFacadeServiceImpl implements UserFacadeService {

    private final FacadeRepository facadeRepository;

    public UserFacadeServiceImpl( @Autowired FacadeRepository facadeRepository)
    {
        this.facadeRepository = facadeRepository;
    }

    @Override
    public UserFacade create(UserFacadeDto userFacadeDto) throws UserException {
        return facadeRepository.save(new UserFacade(userFacadeDto));
    }

    @Override
    public UserFacade findByRealId(String id) throws UserException {
        Optional<UserFacade> optionalUserFacade = facadeRepository.findById(id);
        if (optionalUserFacade.isPresent()) {
            return optionalUserFacade.get();
        } else {
            throw new UserException("Not Found");
        }
    }

    @Override
    public List<UserFacade> all() {
        return facadeRepository.findAll();
    }

    @Override
    public boolean deleteByRealId(String id) throws UserException {
        if(facadeRepository.existsById(id)){
            facadeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public UserFacade update(String id, UserFacadeDto userFacadeDto) throws UserException {

        Optional<UserFacade> u = facadeRepository.findById(id);
        UserFacade userFacade = null;
        if(u.isPresent()){
            userFacade = u.get();
            userFacade.updateFacade(userFacadeDto.getFakeName(), userFacadeDto.getPhoto(), userFacadeDto.getHashTags());
            facadeRepository.save(userFacade);

        }
        return userFacade;
    }

    @Override
    public List<UserFacade> findSomeById(List<String> usersId) throws UserException {

        List<UserFacade> users = new ArrayList();
        for(String id : usersId){
            users.add(findByRealId(id));
        }
        return users;
    }
}
