package edu.eci.ieti.proyect.entity;

import edu.eci.ieti.proyect.dto.UniversityDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class University {

    @Id
    private String id;
    private String name;


    public  University(){}

    public University(String name, String id, List<User> students) {
        this.name = name;
        this.id = id;

    }

    public University(UniversityDto universityDto) {
        this.id = UUID.randomUUID().toString();
        this.name = universityDto.getName();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public void update(UniversityDto universityDto){
        this.name = universityDto.getName();

    }
}
