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

    private List<User> students;

    public University(String name, String id, List<User> students) {
        this.name = name;
        this.id = id;
        this.students = students;
    }

    public University(UniversityDto universityDto) {
        this.id = UUID.randomUUID().toString();
        this.name = universityDto.getName();
        this.students = null;
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

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    public void update(UniversityDto universityDto){
        this.name = universityDto.getName();

    }
}
