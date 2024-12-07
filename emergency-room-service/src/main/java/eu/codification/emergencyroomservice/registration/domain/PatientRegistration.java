package eu.codification.emergencyroomservice.registration.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientRegistration {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private int height;
    private int weight;
    private LocalDate hospitalAdmission = LocalDate.now();
    private String documentId;
}