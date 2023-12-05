package eu.codification.emergencyroomservice.registration.controller;

import eu.codification.emergencyroomservice.registration.dto.PatientRegistrationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/registration")
public class PatientRegistrationController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping
    public ResponseEntity<?> patientRegistration(@RequestBody PatientRegistrationDTO patientRegistrationDTO) {
        log.info(patientRegistrationDTO.toString());
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

}
