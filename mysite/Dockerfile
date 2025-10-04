# Stage 1: Build JAR
FROM maven:3.9.9-eclipse-temurin-24 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run JAR
FROM eclipse-temurin:24-jdk-alpine
WORKDIR /mysite
COPY --from=build /app/target/mysite-0.0.1-SNAPSHOT.jar mysite.jar
ENTRYPOINT ["java","-jar","mysite.jar"]
EXPOSE 8080
