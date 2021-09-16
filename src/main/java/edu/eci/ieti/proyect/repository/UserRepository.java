package edu.eci.ieti.proyect.repository;

import edu.eci.ieti.proyect.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findByEmail(String email);
}
