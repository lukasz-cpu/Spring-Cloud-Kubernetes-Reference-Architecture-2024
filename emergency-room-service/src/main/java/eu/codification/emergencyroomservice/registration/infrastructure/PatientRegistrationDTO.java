package eu.codification.emergencyroomservice.registration.infrastructure;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientRegistrationDTO {
  private String firstName;
  private String lastName;
  private String email;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateOfBirth;

  private int height;
  private int weight;
  private String documentId;
}
