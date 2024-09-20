FROM eclipse-temurin:17.0.12_7-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} OrdenService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/OrdenService-0.0.1-SNAPSHOT.jar"]