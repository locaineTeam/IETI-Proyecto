package edu.eci.ieti.proyect.entity;





import edu.eci.ieti.proyect.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;


import java.security.Timestamp;
import java.util.UUID;

@Document
public class User {

    @Id
    private String id;
    private String name;
    @Indexed(unique=true)
    private String email;
    private String lastName;
    private String birthDate;
    private String foto;
    private String descripcion;
    private String password;

    public User() {
    }



    public User(UserDto user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDay();
        this.foto = user.getFoto();
        this.descripcion = user.getDescripcion();
        this.password = BCrypt.hashpw( user.getPassword(), BCrypt.gensalt() );

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public void update (UserDto userDto){
        this.name = userDto.getName();
        this.birthDate = userDto.getBirthDay();
        this.descripcion = userDto.getDescripcion();
        this.email = userDto.getEmail();
        this.foto = userDto.getFoto();
        this.password = BCrypt.hashpw( userDto.getPassword(), BCrypt.gensalt() );
        this.lastName = userDto.getLastName();
    }
}
