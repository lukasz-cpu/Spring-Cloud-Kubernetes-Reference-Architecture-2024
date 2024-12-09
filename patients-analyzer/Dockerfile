FROM openjdk:21-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} patients-analyzer.jar
ENTRYPOINT ["java","-jar","/patients-analyzer.jar"]