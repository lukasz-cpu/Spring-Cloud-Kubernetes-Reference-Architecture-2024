package eu.codification.emergencyroomservice.registration.service;

import eu.codification.emergencyroomservice.registration.entities.PatientRegistrationEntity;
import eu.codification.emergencyroomservice.registration.mappers.PatientRegistrationMapper;
import eu.codification.emergencyroomservice.registration.model.PatientRegistration;
import eu.codification.emergencyroomservice.registration.repository.PatientRegistrationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PatientRegistrationService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final PatientRegistrationRepository patientRegistrationRepository;

    public PatientRegistrationService(PatientRegistrationRepository patientRegistrationRepository) {
        this.patientRegistrationRepository = patientRegistrationRepository;
    }

    public void proceedWithRegistration(PatientRegistration patientRegistration) {
        PatientRegistrationEntity patientRegistrationEntity = PatientRegistrationMapper.mapToEntity(patientRegistration);
        PatientRegistrationEntity save = patientRegistrationRepository.save(patientRegistrationEntity);
        log.info(save.getId());

    }
}
