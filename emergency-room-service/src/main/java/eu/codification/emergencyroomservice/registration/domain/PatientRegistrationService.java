package eu.codification.emergencyroomservice.registration.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.codification.emergencyroomservice.registration.infrastructure.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PatientRegistrationService {

  private final Logger log = LoggerFactory.getLogger(getClass());
  private final PatientRegistrationRepository patientRegistrationRepository;
  private final PatientsOutboxRegistrationRepository patientsOutboxRegistrationRepository;
  private final KafkaTemplate<String, String> kafkaTemplate;

  private ObjectMapper objectMapper;

  public PatientRegistrationService(
      PatientRegistrationRepository patientRegistrationRepository,
      PatientsOutboxRegistrationRepository patientsOutboxRegistrationRepository,
      KafkaTemplate<String, String> kafkaTemplate,
      ObjectMapper objectMapper) {
    this.patientRegistrationRepository = patientRegistrationRepository;
    this.patientsOutboxRegistrationRepository = patientsOutboxRegistrationRepository;
    this.kafkaTemplate = kafkaTemplate;
    this.objectMapper = objectMapper;
  }

  @Transactional
  public void proceedWithRegistration(PatientRegistration patientRegistration)
      throws JsonProcessingException {

    PatientRegistrationEntity patientRegistrationEntity =
        PatientRegistrationMapper.mapToEntity(patientRegistration);

    PatientRegistrationEntity savedRegistration =
        patientRegistrationRepository.save(patientRegistrationEntity);
    kafkaTemplate.send("asd", "asd");
  }
}
