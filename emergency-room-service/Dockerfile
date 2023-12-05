FROM openjdk:21-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} emergency-room-service.jar
ENTRYPOINT ["java","-jar","/emergency-room-service.jar"]