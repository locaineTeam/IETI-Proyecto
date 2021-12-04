
package edu.eci.ieti.proyect.repository;

import edu.eci.ieti.proyect.entity.University;
import edu.eci.ieti.proyect.entity.UserFacade;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FacadeRepository extends MongoRepository<UserFacade,String> {




}
