package eu.codification.patientsanalyzer.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PatientsRegistrationReceiver {

    @KafkaListener(topics = "${kafka.registration.topic}")
    public void listenToPatientRegistrationTopic(String message) {
        log.info("Received message from Kafka topic '{}'", message);
    }
    
}
