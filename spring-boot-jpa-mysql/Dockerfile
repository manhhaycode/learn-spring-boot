# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

LABEL authors="manhnguyen"

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file built by your Spring Boot application into the container at the working directory
COPY target/spring-boot-jpa-mysql-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application will run on
EXPOSE 8080

# Specify the command to run your application when the container starts
CMD ["java", "-jar", "app.jar"]