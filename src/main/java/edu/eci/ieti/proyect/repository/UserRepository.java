package edu.eci.ieti.proyect.repository;

import edu.eci.ieti.proyect.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findByEmail(String email);

    List<User> findByUniversidad(String universidad);

    List<User> findByUniversidadAndAndGenero(String universidad, String genero);




}
