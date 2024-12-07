package eu.codification.emergencyroomservice.registration.domain;

import eu.codification.emergencyroomservice.registration.infrastructure.PatientRegistrationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRegistrationRepository extends MongoRepository<PatientRegistrationEntity, UUID> {
}
