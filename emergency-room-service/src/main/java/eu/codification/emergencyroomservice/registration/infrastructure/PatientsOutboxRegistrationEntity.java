package eu.codification.emergencyroomservice.registration.infrastructure;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Setter
@Document(collection = "patient_outbox_registration")
public class PatientsOutboxRegistrationEntity {

  @Id private String id;
  private String aggregateId;
  private String aggregateType;
  private PatientEventType eventType;
  private String payload;
  private PatientRegistationStatus status;
  private LocalDateTime createdAt;
}
