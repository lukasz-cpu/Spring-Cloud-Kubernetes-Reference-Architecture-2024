package eu.codification.emergencyroomservice.registration.domain;

import eu.codification.emergencyroomservice.registration.infrastructure.PatientRegistationStatus;
import eu.codification.emergencyroomservice.registration.infrastructure.PatientsOutboxRegistrationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientsOutboxRegistrationRepository
        extends MongoRepository<PatientsOutboxRegistrationEntity, String> {

    List<PatientsOutboxRegistrationEntity> findByStatus(PatientRegistationStatus status);

}
