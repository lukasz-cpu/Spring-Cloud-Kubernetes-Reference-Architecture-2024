package eu.codification.emergencyroomservice.registration.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.codification.emergencyroomservice.registration.infrastructure.PatientRegistrationEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PatientRegistrationService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final PatientRegistrationRepository patientRegistrationRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${kafka.patient-registration.topic}")
    private String customProperty;


    private ObjectMapper objectMapper;

    public PatientRegistrationService(PatientRegistrationRepository patientRegistrationRepository,
                                      KafkaTemplate<String, String> kafkaTemplate,
                                      ObjectMapper objectMapper) {
        this.patientRegistrationRepository = patientRegistrationRepository;
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void proceedWithRegistration(PatientRegistration patientRegistration) throws JsonProcessingException {
        PatientRegistrationEntity patientRegistrationEntity = PatientRegistrationMapper.mapToEntity(patientRegistration);
        PatientRegistrationEntity savedRegistration = patientRegistrationRepository.save(patientRegistrationEntity);
        log.info("Successfully saved item to the database with patient's id: {}", savedRegistration.getPatientId());
        String payLoad = objectMapper.writeValueAsString(patientRegistration);
        log.info("Successfully saved item to the database with patient: {}", payLoad);
        kafkaTemplate.send(customProperty, payLoad);
    }
}
