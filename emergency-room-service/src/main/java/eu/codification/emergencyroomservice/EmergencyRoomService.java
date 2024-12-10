package eu.codification.emergencyroomservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmergencyRoomService {

  public static void main(String[] args) {
    SpringApplication.run(EmergencyRoomService.class, args);
  }
}
