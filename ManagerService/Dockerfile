# Use lightweight JDK base image
FROM eclipse-temurin:17-jdk-alpine 

# Set working directory
WORKDIR /app

# Copy the JAR file from build context
COPY target/ManagerService-0.0.1-SNAPSHOT.jar app.jar  
# Expose the application port
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
