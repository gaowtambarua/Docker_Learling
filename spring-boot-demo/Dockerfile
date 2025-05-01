# Step 1: Use an official Java 21 runtime as a parent image
FROM eclipse-temurin:21-jdk-jammy

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy the built jar file into the container
COPY target/spring-boot-demo-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
