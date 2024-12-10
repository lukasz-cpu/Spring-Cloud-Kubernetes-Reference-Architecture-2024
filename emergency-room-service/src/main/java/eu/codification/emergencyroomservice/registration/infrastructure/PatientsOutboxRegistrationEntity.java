package eu.codification.emergencyroomservice.registration.infrastructure;

import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patient_outbox_registration")
public class PatientsOutboxRegistrationEntity {

  @Id private String id;
  private String aggregateId;
  private String aggregateType;
  private String eventType;
  private String payload;
  private String status;
  private LocalDateTime createdAt;

  public PatientsOutboxRegistrationEntity() {}

  public PatientsOutboxRegistrationEntity(
      String id,
      String aggregateId,
      String aggregateType,
      String eventType,
      String payload,
      String status,
      LocalDateTime createdAt) {
    this.id = id;
    this.aggregateId = aggregateId;
    this.aggregateType = aggregateType;
    this.eventType = eventType;
    this.payload = payload;
    this.status = status;
    this.createdAt = createdAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAggregateId() {
    return aggregateId;
  }

  public void setAggregateId(String aggregateId) {
    this.aggregateId = aggregateId;
  }

  public String getAggregateType() {
    return aggregateType;
  }

  public void setAggregateType(String aggregateType) {
    this.aggregateType = aggregateType;
  }

  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PatientsOutboxRegistrationEntity that = (PatientsOutboxRegistrationEntity) o;

    if (!Objects.equals(id, that.id)) return false;
    if (!Objects.equals(aggregateId, that.aggregateId)) return false;
    if (!Objects.equals(eventType, that.eventType)) return false;
    return Objects.equals(status, that.status);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (aggregateId != null ? aggregateId.hashCode() : 0);
    result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
    result = 31 * result + (status != null ? status.hashCode() : 0);
    return result;
  }

  public static PatientsOutboxRegistrationEntityBuilder builder() {
    return new PatientsOutboxRegistrationEntityBuilder();
  }

  public static class PatientsOutboxRegistrationEntityBuilder {

    private String id;
    private String aggregateId;
    private String aggregateType;
    private String eventType;
    private String payload;
    private String status;
    private LocalDateTime createdAt;

    public PatientsOutboxRegistrationEntityBuilder id(String id) {
      this.id = id;
      return this;
    }

    public PatientsOutboxRegistrationEntityBuilder aggregateId(String aggregateId) {
      this.aggregateId = aggregateId;
      return this;
    }

    public PatientsOutboxRegistrationEntityBuilder aggregateType(String aggregateType) {
      this.aggregateType = aggregateType;
      return this;
    }

    public PatientsOutboxRegistrationEntityBuilder eventType(String eventType) {
      this.eventType = eventType;
      return this;
    }

    public PatientsOutboxRegistrationEntityBuilder payload(String payload) {
      this.payload = payload;
      return this;
    }

    public PatientsOutboxRegistrationEntityBuilder status(String status) {
      this.status = status;
      return this;
    }

    public PatientsOutboxRegistrationEntityBuilder createdAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public PatientsOutboxRegistrationEntity build() {
      return new PatientsOutboxRegistrationEntity(
          id, aggregateId, aggregateType, eventType, payload, status, createdAt);
    }
  }
}
