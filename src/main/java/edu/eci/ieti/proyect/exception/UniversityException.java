package edu.eci.ieti.proyect.exception;

public class UniversityException extends Exception {

    public static final String UNIVERSITY_NOT_FOUND = "Univerity not found, please verify entry data";
    public UniversityException(String message) {
        super(message);
    }
}

