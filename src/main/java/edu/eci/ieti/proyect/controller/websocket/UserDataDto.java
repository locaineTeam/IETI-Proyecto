package edu.eci.ieti.proyect.controller.websocket;

public class UserDataDto {
    
    private String id;
    private String name;
    private String lastName;

    public UserDataDto(String id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj) {
        
        if(obj instanceof UserDataDto){
            UserDataDto user = (UserDataDto) obj;
            if(this.id.equals(user.getId())){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
}
