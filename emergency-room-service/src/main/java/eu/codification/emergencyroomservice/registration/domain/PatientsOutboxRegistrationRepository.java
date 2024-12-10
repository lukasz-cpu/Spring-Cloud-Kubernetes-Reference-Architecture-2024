package eu.codification.emergencyroomservice.registration.domain;

import eu.codification.emergencyroomservice.registration.infrastructure.PatientsOutboxRegistrationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsOutboxRegistrationRepository
        extends MongoRepository<PatientsOutboxRegistrationEntity, String> {}
