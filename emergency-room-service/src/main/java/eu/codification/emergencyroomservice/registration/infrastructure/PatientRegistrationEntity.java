package eu.codification.emergencyroomservice.registration.infrastructure;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@Document(collection = "patient_registration")
public class PatientRegistrationEntity {

  @Id private String id;
  private String patientId;
  private String firstName;
  private String lastName;
  private String email;
  private LocalDate dateOfBirth;
  private int height;
  private int weight;
}
