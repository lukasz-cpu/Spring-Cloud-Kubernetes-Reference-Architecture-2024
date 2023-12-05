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
        return model;
    }

    public static PatientRegistrationEntity mapModelToEntity(PatientRegistration model) {
        PatientRegistrationEntity entity = new PatientRegistrationEntity();
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setEmail(model.getEmail());
        entity.setDateOfBirth(model.getDateOfBirth());
        entity.setHeight(model.getHeight());
        entity.setWeight(model.getWeight());
        return entity;
    }

}
