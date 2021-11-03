
package edu.eci.ieti.proyect.service.impl.university;

import edu.eci.ieti.proyect.dto.UniversityDto;
import edu.eci.ieti.proyect.entity.University;

import edu.eci.ieti.proyect.entity.User;
import edu.eci.ieti.proyect.exception.UniversityException;

import edu.eci.ieti.proyect.repository.UniversityRepository;
import edu.eci.ieti.proyect.repository.UserRepository;
import edu.eci.ieti.proyect.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;
    private final UserRepository userRepository;

    public UniversityServiceImpl( @Autowired UniversityRepository universityRepository, @Autowired UserRepository userRepository )
    {
        this.universityRepository = universityRepository;
        this.userRepository = userRepository;
    }
    @Override
    public University create(UniversityDto universityDto) throws UniversityException {

        return universityRepository.save(new University(universityDto));
    }

    @Override
    public University findById(String id) throws UniversityException {
        Optional<University> university = universityRepository.findById(id);
        if(university.isPresent()) {
            return university.get();
        } else {
            throw new UniversityException("Not Found");
        }
    }

    @Override
    public List<University> all() {
        return universityRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) throws UniversityException {
        boolean flag = false;
        if(universityRepository.existsById(id)){
            universityRepository.deleteById(id);
            return true;
        }
        return flag;
    }

    @Override
    public University update(UniversityDto universityDto, String universityId) throws UniversityException {
        University u = null;
        if(universityRepository.findById(universityId).isPresent()){
            u = universityRepository.findById(universityId).get();
            u.update(universityDto);
            universityRepository.save(u);

        }
        return u;
    }

    @Override
    public University findByName(String name) throws UniversityException {
        Optional<University> university = universityRepository.findByName(name);
        if(university.isPresent()){
            return university.get();
        }
        throw new UniversityException(UniversityException.UNIVERSITY_NOT_FOUND);
    }

    @Override
    public List<User> allStudents(String university) {
        List<User> lista=userRepository.findByUniversidad(university);
        return lista;
    }


}
