package eu.codification.emergencyroomservice.registration.domain;

import eu.codification.emergencyroomservice.registration.infrastructure.PatientRegistrationEntity;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRegistrationRepository
    extends MongoRepository<PatientRegistrationEntity, UUID> {}
