FROM openjdk:21-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} organisation-service.jar
ENTRYPOINT ["java","-jar","/organisation-service.jar"]