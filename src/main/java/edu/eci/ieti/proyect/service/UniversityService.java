package edu.eci.ieti.proyect.service;

import edu.eci.ieti.proyect.dto.UniversityDto;

import edu.eci.ieti.proyect.entity.University;

import edu.eci.ieti.proyect.exception.UniversityException;


import java.util.List;

public interface UniversityService {
    University create(UniversityDto universityDto ) throws UniversityException;

    University findById( String id ) throws UniversityException;

    List<University> all();

    boolean deleteById(String id ) throws UniversityException;


    University update( UniversityDto universityDto, String universityId ) throws UniversityException;


    University findByName(String name) throws UniversityException;


}
