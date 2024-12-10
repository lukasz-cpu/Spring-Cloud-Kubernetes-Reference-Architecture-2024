package eu.codification.emergencyroomservice.registration.infrastructure;

import lombok.Getter;

@Getter
public enum PatientAggregatType {
  PATIENT_REGISTRATION("PatientRegistration");

  private final String value;

  PatientAggregatType(String value) {
    this.value = value;
  }

  public static PatientAggregatType fromValue(String value) {
    for (PatientAggregatType type : PatientAggregatType.values()) {
      if (type.value.equals(value)) {
        return type;
      }
    }
    throw new IllegalArgumentException("Unknown value: " + value);
  }
}
