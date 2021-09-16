package edu.eci.ieti.proyect.controller.verification;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "v1/works" )
public class itWorksController {

    @GetMapping
    public ResponseEntity<String> AllWorks() {
        return new ResponseEntity<>("All is working Correctly", HttpStatus.OK);
    }
}
