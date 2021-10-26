package edu.eci.ieti.proyect.service;

import edu.eci.ieti.proyect.dto.UniversityDto;

import edu.eci.ieti.proyect.entity.University;

import edu.eci.ieti.proyect.entity.User;
import edu.eci.ieti.proyect.exception.UniversityException;


import java.util.List;

public interface UniversityService {
    /**
     * @param universityDto
     * @return
     * @throws UniversityException
     */
    University create(UniversityDto universityDto ) throws UniversityException;

    /**
     * @param id
     * @return
     * @throws UniversityException
     */
    University findById( String id ) throws UniversityException;

    /**
     * @return
     */
    List<University> all();

    /**
     * @param id
     * @return
     * @throws UniversityException
     */
    boolean deleteById(String id ) throws UniversityException;


    /**
     * @param universityDto
     * @param universityId
     * @return
     * @throws UniversityException
     */
    University update( UniversityDto universityDto, String universityId ) throws UniversityException;


    /**
     * @param name
     * @return
     * @throws UniversityException
     */
    University findByName(String name) throws UniversityException;

    /**
     * @param university
     * @return
     */
    List<User> allStudents(String university);

}
