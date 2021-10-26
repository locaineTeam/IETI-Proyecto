package edu.eci.ieti.proyect.repository;

import edu.eci.ieti.proyect.entity.University;
import edu.eci.ieti.proyect.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends MongoRepository<University,String> {

    Optional<University> findByName(String name);


}

