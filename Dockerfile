FROM openjdk:17-jdk-alpine
COPY target/peliculas-api-0.0.1-SNAPSHOT.jar peliculas-api-0.0.1.jar
ENTRYPOINT ["java","-jar","/peliculas-api-0.0.1.jar"]
