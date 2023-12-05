package eu.codification.emergencyroomservice.registration.service;

import eu.codification.emergencyroomservice.registration.repository.PatientRegistrationRepository;
import org.springframework.stereotype.Component;

@Component
public class PatientRegistrationService {
    private final PatientRegistrationRepository patientRegistrationRepository;

    public PatientRegistrationService(PatientRegistrationRepository patientRegistrationRepository) {
        this.patientRegistrationRepository = patientRegistrationRepository;
    }
}
