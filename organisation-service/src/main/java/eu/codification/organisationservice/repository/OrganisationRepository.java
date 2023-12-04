package eu.codification.organisationservice.repository;

import eu.codification.organisationservice.model.Organisation;
import org.springframework.data.repository.CrudRepository;

public interface OrganisationRepository extends CrudRepository<Organisation, String> {

}