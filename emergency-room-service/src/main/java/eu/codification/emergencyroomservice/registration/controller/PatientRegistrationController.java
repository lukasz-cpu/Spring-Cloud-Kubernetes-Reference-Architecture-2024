package eu.codification.emergencyroomservice.registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class PatientRegistrationController {

    @GetMapping
    public ResponseEntity<?> patientRegistration(){
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

}
