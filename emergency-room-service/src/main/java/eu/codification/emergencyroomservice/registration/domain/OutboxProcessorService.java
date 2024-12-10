package eu.codification.emergencyroomservice.registration.domain;

import eu.codification.emergencyroomservice.registration.infrastructure.PatientRegistationStatus;
import eu.codification.emergencyroomservice.registration.infrastructure.PatientsOutboxRegistrationEntity;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OutboxProcessorService {

  private final Logger log = LoggerFactory.getLogger(getClass());
  private final PatientsOutboxRegistrationRepository patientsOutboxRegistrationRepository;
  private final KafkaTemplate<String, String> kafkaTemplate;

  @Value("${kafka.patient-registration.topic}")
  private String patientRegistrationOutBoxTopic;

  public OutboxProcessorService(
      PatientsOutboxRegistrationRepository patientsOutboxRegistrationRepository,
      KafkaTemplate<String, String> kafkaTemplate) {
    this.patientsOutboxRegistrationRepository = patientsOutboxRegistrationRepository;
    this.kafkaTemplate = kafkaTemplate;
  }

  @Transactional
  @Scheduled(fixedRate = 60000)
  public void processPendingOutboxEvents() {
    List<PatientsOutboxRegistrationEntity> pendingOutboxEntries =
        patientsOutboxRegistrationRepository.findByStatus(PatientRegistationStatus.PENDING);

    if (pendingOutboxEntries.isEmpty()) {
      log.info("No pending outbox events to process.");
      return;
    }

    for (PatientsOutboxRegistrationEntity outboxEntity : pendingOutboxEntries) {
      try {
        String payload = outboxEntity.getPayload();
        kafkaTemplate.send(patientRegistrationOutBoxTopic, payload);

        outboxEntity.setStatus(PatientRegistationStatus.SENT);
        patientsOutboxRegistrationRepository.save(outboxEntity);

        log.info(
            "Successfully sent event to Kafka with aggregateId: {}", outboxEntity.getAggregateId());
      } catch (Exception e) {
        log.error(
            "Error sending event to Kafka for aggregateId: {}", outboxEntity.getAggregateId(), e);
      }
    }
  }

    @KafkaListener(topics = "${kafka.patient-registration.topic}", groupId = "default-consumer-group")
    public void listenToPatientRegistrationTopic(String message) {
        log.info("Received message from Kafka topic '{}': {}", patientRegistrationOutBoxTopic, message);
    }
}

