package eu.codification.organizationservice.repository;

import eu.codification.organizationservice.model.Organisation;
import org.springframework.data.repository.CrudRepository;

public interface OrganisationRepository extends CrudRepository<Organisation, String> {

}