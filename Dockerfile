# Use the same version of Java as specified in your POM.xml
FROM openjdk:21-ea-1-jdk-oracle



# Set the working directory in the container
WORKDIR /usr/app

# Copy the Maven packaged JAR file into the container
COPY target/movies-0.0.1-SNAPSHOT.jar /usr/app/movies-0.0.1-SNAPSHOT.jar



# Expose the port that your Spring Boot application listens on
EXPOSE 8080



# Command to run the Spring Boot application
CMD ["java", "-jar", "movies-0.0.1-SNAPSHOT.jar"]
