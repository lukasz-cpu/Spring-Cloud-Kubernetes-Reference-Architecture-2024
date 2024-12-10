package eu.codification.emergencyroomservice.registration.infrastructure;

import java.time.LocalDate;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

  public PatientRegistrationEntity() {}

  public PatientRegistrationEntity(
      String id,
      String patientId,
      String firstName,
      String lastName,
      String email,
      LocalDate dateOfBirth,
      int height,
      int weight) {
    this.id = id;
    this.patientId = patientId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    this.height = height;
    this.weight = weight;
  }

  public static PatientRegistrationEntityBuilder builder() {
    return new PatientRegistrationEntityBuilder();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PatientRegistrationEntity that = (PatientRegistrationEntity) o;

    if (!Objects.equals(id, that.id)) return false;
    if (!Objects.equals(patientId, that.patientId)) return false;
    return Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }

  public static class PatientRegistrationEntityBuilder {

    private String id;
    private String patientId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private int height;
    private int weight;

    public PatientRegistrationEntityBuilder id(String id) {
      this.id = id;
      return this;
    }

    public PatientRegistrationEntityBuilder patientId(String patientId) {
      this.patientId = patientId;
      return this;
    }

    public PatientRegistrationEntityBuilder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public PatientRegistrationEntityBuilder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public PatientRegistrationEntityBuilder email(String email) {
      this.email = email;
      return this;
    }

    public PatientRegistrationEntityBuilder dateOfBirth(LocalDate dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    public PatientRegistrationEntityBuilder height(int height) {
      this.height = height;
      return this;
    }

    public PatientRegistrationEntityBuilder weight(int weight) {
      this.weight = weight;
      return this;
    }

    public PatientRegistrationEntity build() {
      return new PatientRegistrationEntity(
          id, patientId, firstName, lastName, email, dateOfBirth, height, weight);
    }
  }
}
