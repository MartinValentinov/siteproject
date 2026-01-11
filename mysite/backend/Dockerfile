FROM maven:3.9.11-eclipse-temurin-25 AS builder
WORKDIR /build

COPY .. .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:25-jdk
WORKDIR /app

COPY --from=builder /build/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]