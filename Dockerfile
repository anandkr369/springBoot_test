# ===== Step 1: Build the project using Maven =====
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# ===== Step 2: Run the JAR file =====
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Render will set PORT environment variable automatically
ENV PORT=8080

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
