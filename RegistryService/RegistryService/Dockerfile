# Build stage
FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /app

COPY . .

# Make mvnw executable
RUN chmod +x ./mvnw

# Use Maven Wrapper (no apt-get, MUCH faster)
RUN ./mvnw -B -DskipTests clean package

# Runtime stage
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "app.jar"]
