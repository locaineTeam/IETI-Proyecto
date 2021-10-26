package edu.eci.ieti.proyect.service;

import edu.eci.ieti.proyect.dto.UserDto;
import edu.eci.ieti.proyect.dto.UserFacadeDto;
import edu.eci.ieti.proyect.entity.User;
import edu.eci.ieti.proyect.entity.UserFacade;
import edu.eci.ieti.proyect.exception.UserException;

import java.util.List;

public interface UserFacadeService {

    /**
     * @param userFacadeDto
     * @return
     * @throws UserException
     */
    UserFacade create(UserFacadeDto userFacadeDto ) throws UserException;

    /**
     * @param id
     * @return
     * @throws UserException
     */
    UserFacade findByRealId( String id ) throws UserException;

    /**
     * @return
     */
    List<UserFacade> all();

    /**
     * @param id
     * @return
     * @throws UserException
     */
    boolean deleteByRealId(String id ) throws UserException;

    /**
     * @param fakeName
     * @param photo
     * @param userRealId
     * @return
     * @throws UserException
     */
    UserFacade update( String fakeName, String photo, String userRealId ) throws UserException;



}
