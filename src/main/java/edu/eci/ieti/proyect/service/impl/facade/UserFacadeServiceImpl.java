
package edu.eci.ieti.proyect.service.impl.facade;

import edu.eci.ieti.proyect.dto.UserFacadeDto;
import edu.eci.ieti.proyect.entity.UserFacade;
import edu.eci.ieti.proyect.exception.UserException;
import edu.eci.ieti.proyect.repository.FacadeRopository;
import edu.eci.ieti.proyect.service.UserFacadeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserFacadeServiceImpl implements UserFacadeService {

    private final FacadeRopository facadeRopository;

    public UserFacadeServiceImpl( @Autowired FacadeRopository facadeRopository )
    {
        this.facadeRopository = facadeRopository;
    }

    @Override
    public UserFacade create(UserFacadeDto userFacadeDto) throws UserException {
        return facadeRopository.save(new UserFacade(userFacadeDto));
    }

    @Override
    public UserFacade findByRealId(String id) throws UserException {
        Optional<UserFacade> optionalUserFacade = facadeRopository.findById(id);
        if (optionalUserFacade.isPresent()) {
            return optionalUserFacade.get();
        } else {
            throw new UserException("Not Found");
        }
    }

    @Override
    public List<UserFacade> all() {
        return facadeRopository.findAll();
    }

    @Override
    public boolean deleteByRealId(String id) throws UserException {
        boolean flag = false;
        if(facadeRopository.existsById(id)){
            facadeRopository.deleteById(id);
            return true;
        }
        return flag;
    }

    @Override
    public UserFacade update(String fakeName, String photo, String userRealId) throws UserException {

        UserFacade u = null;
        if(facadeRopository.findById(userRealId).isPresent()){
            u = facadeRopository.findById(userRealId).get();
            u.updateFacade(fakeName,photo);
            facadeRopository.save(u);

        }
        return u;
    }
}
