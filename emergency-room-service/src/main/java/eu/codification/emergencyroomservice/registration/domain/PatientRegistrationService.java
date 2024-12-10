package eu.codification.emergencyroomservice.registration.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.codification.emergencyroomservice.registration.infrastructure.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PatientRegistrationService {

  private final Logger log = LoggerFactory.getLogger(getClass());
  private final PatientRegistrationRepository patientRegistrationRepository;
  private final PatientsOutboxRegistrationRepository patientsOutboxRegistrationRepository;
  private final KafkaTemplate<String, String> kafkaTemplate;

  @Value("${kafka.patient-registration.topic}")
  private String customProperty;

  private ObjectMapper objectMapper;

  public PatientRegistrationService(
          PatientRegistrationRepository patientRegistrationRepository,
          PatientsOutboxRegistrationRepository patientsOutboxRegistrationRepository, PatientsOutboxRegistrationRepository patientsOutboxRegistrationRepository1,
          KafkaTemplate<String, String> kafkaTemplate,
          ObjectMapper objectMapper) {
    this.patientRegistrationRepository = patientRegistrationRepository;
      this.patientsOutboxRegistrationRepository = patientsOutboxRegistrationRepository1;
      this.kafkaTemplate = kafkaTemplate;
    this.objectMapper = objectMapper;
  }

  public void proceedWithRegistration(PatientRegistration patientRegistration)
      throws JsonProcessingException {

    PatientRegistrationEntity patientRegistrationEntity =
        PatientRegistrationMapper.mapToEntity(patientRegistration);

    PatientRegistrationEntity savedRegistration =
        patientRegistrationRepository.save(patientRegistrationEntity);

    log.info(
        "Successfully saved item to patient repository with patient's id: {}",
        savedRegistration.getPatientId());

    String payLoad = objectMapper.writeValueAsString(patientRegistration);

    PatientsOutboxRegistrationEntity patientsOutboxRegistrationEntity =
        PatientRegistrationMapper.mapToOutboxEntity(savedRegistration, payLoad);

    PatientsOutboxRegistrationEntity savedOutBox = patientsOutboxRegistrationRepository.save(patientsOutboxRegistrationEntity);

    log.info("Successfully saved item to outbox repository with patient's id: {}", savedOutBox.getAggregateId());
    
  }
}
