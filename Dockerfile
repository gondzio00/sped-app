FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080