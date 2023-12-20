package eu.codification.emergencyroomservice.registration.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import eu.codification.emergencyroomservice.registration.entities.PatientRegistrationEntity;
import eu.codification.emergencyroomservice.registration.mappers.PatientRegistrationMapper;
import eu.codification.emergencyroomservice.registration.model.PatientRegistration;
import eu.codification.emergencyroomservice.registration.repository.PatientRegistrationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PatientRegistrationService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final PatientRegistrationRepository patientRegistrationRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    private ObjectMapper objectMapper;

    public PatientRegistrationService(PatientRegistrationRepository patientRegistrationRepository, KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
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
        kafkaTemplate.send("new-registration", payLoad);
    }
}
