package eu.codification.emergencyroomservice.registration.infrastructure;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Document(collection = "patient_registration")
public class PatientRegistrationEntity {

  @Id private String id;
  private final String patientId;
  private final String firstName;
  private final String lastName;
  private final String email;
  private final LocalDate dateOfBirth;
  private final int height;
  private final int weight;
}
