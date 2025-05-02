######## Ai code ti hoccce Docker er moddhe Maven run
######## hoye jar file ready korbe,shai jar file diye result dekhabe
# .dockerignore er modddhe /target  on kore dite hobe joohon ai code ti use hobe.jate docker terget ignore kore
################################################


## Build stage (Java 21 দিয়ে)
#FROM maven:3.9.6-eclipse-temurin-21 AS build
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package -DskipTests
#
## Run stage (Java 21 দিয়ে)
#FROM eclipse-temurin:21-jre-jammy
#WORKDIR /app
#COPY --from=build /app/target/Working_With_Api-*.jar app.jar
#CMD ["java", "-jar", "app.jar"]





######## Ai code ti war file thake result niye dekhabe
########
################################################


# Just run the jar using JRE
# Step 1: Use an OpenJDK base image with JRE
FROM eclipse-temurin:21-jre-jammy

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the pre-built JAR file from your local machine to the container
COPY target/Working_With_Api-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Run the JAR file using the JRE
CMD ["java", "-jar", "app.jar"]
