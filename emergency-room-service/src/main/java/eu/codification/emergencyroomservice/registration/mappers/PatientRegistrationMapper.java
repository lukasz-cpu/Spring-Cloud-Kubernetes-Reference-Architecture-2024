package eu.codification.emergencyroomservice.registration.mappers;

import eu.codification.emergencyroomservice.registration.dto.PatientRegistrationDTO;
import eu.codification.emergencyroomservice.registration.entities.PatientRegistrationEntity;
import eu.codification.emergencyroomservice.registration.model.PatientRegistration;

import java.time.LocalDate;

public class PatientRegistrationMapper {

    public static PatientRegistration mapDtoToModel(PatientRegistrationDTO dto) {
        PatientRegistration model = new PatientRegistration();
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setEmail(dto.getEmail());
        model.setDateOfBirth(dto.getDateOfBirth());
        model.setHeight(dto.getHeight());
        model.setWeight(dto.getWeight());
        model.setHospitalAdmission(LocalDate.now()); // Assuming you want to set the current date for hospital admission
        model.setDocumentId(dto.getDocumentId());
        return model;
    }

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
