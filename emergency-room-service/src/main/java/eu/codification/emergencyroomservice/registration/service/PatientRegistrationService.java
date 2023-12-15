package eu.codification.emergencyroomservice.registration.service;

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
    private final KafkaTemplate kafkaTemplate;

    public PatientRegistrationService(PatientRegistrationRepository patientRegistrationRepository, KafkaTemplate kafkaTemplate) {
        this.patientRegistrationRepository = patientRegistrationRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void proceedWithRegistration(PatientRegistration patientRegistration) {
        PatientRegistrationEntity patientRegistrationEntity = PatientRegistrationMapper.mapToEntity(patientRegistration);
        PatientRegistrationEntity savedRegistration = patientRegistrationRepository.save(patientRegistrationEntity);
        log.info("Successfully saved item to the database with patient's id: {}", savedRegistration.getPatientId());
        kafkaTemplate.send("new-registration", patientRegistration);
    }
}
