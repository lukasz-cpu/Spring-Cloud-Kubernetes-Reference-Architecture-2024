package eu.codification.emergencyroomservice.registration.infrastructure;

import eu.codification.emergencyroomservice.registration.model.PatientRegistration;

public class PatientRegistationEntityMapper {

    public static PatientRegistrationEntity mapToEntity(PatientRegistration patientRegistration) {
        return PatientRegistrationEntity.builder()
                .patientId(patientRegistration.getDocumentId())
                .firstName(patientRegistration.getFirstName())
                .lastName(patientRegistration.getLastName())
                .email(patientRegistration.getEmail())
                .dateOfBirth(patientRegistration.getDateOfBirth())
                .height(patientRegistration.getHeight())
                .weight(patientRegistration.getWeight())
                .build();
    }
}
