package eu.codification.emergencyroomservice.registration.domain;

import eu.codification.emergencyroomservice.registration.infrastructure.*;
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
    model.setHospitalAdmission(
        LocalDate.now()); // Assuming you want to set the current date for hospital admission
    model.setDocumentId(dto.getDocumentId());
    return model;
  }

  public static PatientsOutboxRegistrationEntity mapToOutboxEntity(
      PatientRegistrationEntity savedRegistration, String payLoad) {
    return PatientsOutboxRegistrationEntity.builder()
        .aggregateId(savedRegistration.getPatientId())
        .aggregateType(PatientAggregatType.PATIENT_REGISTRATION.getValue())
        .eventType(PatientEventType.CREATED)
        .payload(payLoad)
        .status(PatientRegistationStatus.PENDING)
        .build();
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
