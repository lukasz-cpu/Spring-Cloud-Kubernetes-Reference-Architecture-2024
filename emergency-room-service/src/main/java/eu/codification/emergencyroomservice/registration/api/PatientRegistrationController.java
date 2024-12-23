package eu.codification.emergencyroomservice.registration.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu.codification.emergencyroomservice.registration.domain.PatientRegistration;
import eu.codification.emergencyroomservice.registration.domain.PatientRegistrationMapper;
import eu.codification.emergencyroomservice.registration.domain.PatientRegistrationService;
import eu.codification.emergencyroomservice.registration.infrastructure.PatientRegistrationDTO;
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
  private final PatientRegistrationService patientRegistrationService;

  public PatientRegistrationController(PatientRegistrationService patientRegistrationService) {
    this.patientRegistrationService = patientRegistrationService;
  }

  @PostMapping
  public ResponseEntity<?> patientRegistration(
      @RequestBody PatientRegistrationDTO patientRegistrationDTO) throws JsonProcessingException {
    PatientRegistration patientRegistration =
        PatientRegistrationMapper.mapDtoToModel(patientRegistrationDTO);
    patientRegistrationService.proceedWithRegistration(patientRegistration);
    //comment
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
