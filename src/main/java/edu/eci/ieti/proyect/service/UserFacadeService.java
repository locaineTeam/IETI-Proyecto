
package edu.eci.ieti.proyect.service;

import edu.eci.ieti.proyect.dto.UserFacadeDto;
import edu.eci.ieti.proyect.entity.UserFacade;
import edu.eci.ieti.proyect.exception.UserException;

import java.util.List;

public interface UserFacadeService {

    UserFacade create(UserFacadeDto userFacadeDto ) throws UserException;

    UserFacade findByRealId( String id ) throws UserException;

    List<UserFacade> all();

    boolean deleteByRealId(String id ) throws UserException;

    UserFacade update(String id, UserFacadeDto userFacadeDto) throws UserException;

    List<UserFacade> findSomeById(List<String> usersId) throws UserException;

}
