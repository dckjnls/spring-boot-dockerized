### STAGE 1: Build ###
FROM maven:3.8-adoptopenjdk-16-openj9 AS build
RUN mkdir -p /build
WORKDIR /build
COPY pom.xml /build
COPY src /build/src
RUN mvn -f pom.xml clean package

### STAGE 2: Run ###
FROM adoptopenjdk:16-jdk-openj9
WORKDIR /app
COPY --from=build /build/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]