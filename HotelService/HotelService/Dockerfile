# Build stage
FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /app

COPY . .

# Use Maven Wrapper (no apt-get, MUCH faster)
RUN ./mvnw -B -DskipTests clean package

# Runtime stage
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
