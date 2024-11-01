package eu.codification.emergencyroomservice.registration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu.codification.emergencyroomservice.registration.dto.PatientRegistrationDTO;
import eu.codification.emergencyroomservice.registration.mappers.PatientRegistrationMapper;
import eu.codification.emergencyroomservice.registration.model.PatientRegistration;
import eu.codification.emergencyroomservice.registration.service.PatientRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping(value = "/registration")
public class PatientRegistrationController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final PatientRegistrationService patientRegistrationService;

    @Value("${my.custom.property}")
    private String customProperty;

    public PatientRegistrationController(PatientRegistrationService patientRegistrationService) {
        this.patientRegistrationService = patientRegistrationService;
    }

    @PostMapping
    public ResponseEntity<?> patientRegistration(@RequestBody PatientRegistrationDTO patientRegistrationDTO) throws JsonProcessingException {
        PatientRegistration patientRegistration = PatientRegistrationMapper.mapDtoToModel(patientRegistrationDTO);
        patientRegistrationService.proceedWithRegistration(patientRegistration);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/custom-property")
    public ResponseEntity<String> getCustomProperty() {
        return new ResponseEntity<>(customProperty, HttpStatus.OK);
    }
}
