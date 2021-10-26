package edu.eci.ieti.proyect.exception;

public class UserException extends Exception {

    public static final String USER_NOT_FOUND = "User not found, please verify entry data";
    public UserException(String message) {
        super(message);
    }
}
