package eu.codification.emergencyroomservice.registration.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.codification.emergencyroomservice.registration.entities.PatientRegistrationEntity;
import eu.codification.emergencyroomservice.registration.model.PatientRegistration;
import eu.codification.emergencyroomservice.registration.repository.PatientRegistrationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PatientRegistrationServiceTest {

    @Mock
    private PatientRegistrationRepository patientRegistrationRepository;

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @Mock
    private ObjectMapper objectMapper;

    private PatientRegistrationService patientRegistrationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        patientRegistrationService = new PatientRegistrationService(patientRegistrationRepository, kafkaTemplate, objectMapper);
    }

    @Test
    void proceedWithRegistration_shouldSaveEntityAndSendKafkaMessage() throws JsonProcessingException {
        PatientRegistration patientRegistration = new PatientRegistration();
        PatientRegistrationEntity savedEntity = new PatientRegistrationEntity();
        savedEntity.setPatientId("1");

        when(patientRegistrationRepository.save(any(PatientRegistrationEntity.class))).thenReturn(savedEntity);
        when(objectMapper.writeValueAsString(any(PatientRegistration.class))).thenReturn("{}");

        patientRegistrationService.proceedWithRegistration(patientRegistration);

        verify(patientRegistrationRepository).save(any(PatientRegistrationEntity.class));
        verify(objectMapper).writeValueAsString(patientRegistration);
        verify(kafkaTemplate).send(eq("minikube-topic"), eq("{}"));
    }

    @Test
    void proceedWithRegistration_shouldHandleJsonProcessingException() throws JsonProcessingException {
        PatientRegistration patientRegistration = new PatientRegistration();
        PatientRegistrationEntity savedEntity = new PatientRegistrationEntity();
        savedEntity.setPatientId("1");

        when(patientRegistrationRepository.save(any(PatientRegistrationEntity.class))).thenReturn(savedEntity);
        when(objectMapper.writeValueAsString(any(PatientRegistration.class))).thenThrow(new JsonProcessingException("Test exception") {});

        try {
            patientRegistrationService.proceedWithRegistration(patientRegistration);
        } catch (JsonProcessingException e) {
            // Expected exception
        }

        verify(patientRegistrationRepository).save(any(PatientRegistrationEntity.class));
        verify(objectMapper).writeValueAsString(patientRegistration);
        verify(kafkaTemplate, never()).send(anyString(), anyString());
    }
}