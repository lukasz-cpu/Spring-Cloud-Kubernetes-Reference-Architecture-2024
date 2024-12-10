package eu.codification.emergencyroomservice.registration.infrastructure;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document(collection = "patient_outbox_registration")
public class PatientsOutboxRegistrationEntity {

  @Id private String id;
  private final String aggregateId;
  private final String aggregateType;
  private final PatientEventType eventType;
  private final String payload;
  private final PatientRegistationStatus status;
  private final LocalDateTime createdAt;
}
