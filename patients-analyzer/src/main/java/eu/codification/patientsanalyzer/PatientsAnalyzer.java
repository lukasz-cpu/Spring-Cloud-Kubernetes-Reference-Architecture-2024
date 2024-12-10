package eu.codification.patientsanalyzer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaHandler;

@SpringBootApplication
public class PatientsAnalyzer {

  public static void main(String[] args) {
    SpringApplication.run(PatientsAnalyzer.class, args);
  }

  @KafkaHandler
  public void process(ConsumerRecord<String, String> record) {}
}
