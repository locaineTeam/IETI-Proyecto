package edu.eci.ieti.proyect.exception;

public class UserException extends Exception {

    public static final String USER_NOT_FOUND = "User not found, please verify entry data";
    public static final String USER_IS_ALREADY_FRIEND = "User is already friend";
    public static final String USER_NO_IN_REQUEST = "User don't send any request to match";
    public UserException(String message) {
        super(message);
    }
}
