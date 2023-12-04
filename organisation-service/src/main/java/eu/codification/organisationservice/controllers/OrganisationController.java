package eu.codification.organisationservice.controllers;

import eu.codification.organisationservice.model.Organisation;
import eu.codification.organisationservice.repository.OrganisationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrganisationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganisationController.class);

    private final OrganisationRepository organisationRepository;

    public OrganisationController(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    @PostMapping
    public Organisation add(@RequestBody Organisation organisation) {
        LOGGER.info("Organisation add: {}", organisation);
        return organisationRepository.save(organisation);
    }

    @GetMapping
    public Iterable<Organisation> findAll() {
        LOGGER.info("Organisation find");
        return organisationRepository.findAll();
    }
}