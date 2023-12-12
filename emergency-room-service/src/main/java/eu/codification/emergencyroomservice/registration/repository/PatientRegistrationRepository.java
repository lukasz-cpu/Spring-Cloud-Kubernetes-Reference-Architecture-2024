package eu.codification.emergencyroomservice.registration.repository;

import eu.codification.emergencyroomservice.registration.entities.PatientRegistrationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRegistrationRepository extends MongoRepository<PatientRegistrationEntity, UUID> {
}
