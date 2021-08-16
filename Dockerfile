FROM adoptopenjdk:16-jdk-openj9
WORKDIR /app
COPY ./target/spring-boot-docker-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]