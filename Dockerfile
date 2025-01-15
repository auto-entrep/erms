#FROM openjdk:17-oracle
#VOLUME /temp
#COPY target/*.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]

# Use the official Oracle JDK as a parent image
FROM oracle/graalvm-ce:java17
# Set the working directory
WORKDIR /app
# Copy the current directory contents into the container at /app
COPY . /app
# Install necessary packages
RUN apt-get update && apt-get install -y oracle-sqlcl
# Make port 8080 available to the world outside this container
EXPOSE 8080
# Run the application
CMD ["java", "-cp", "erms.jar", "erms"]





# Run app.py when the container launches
CMD ["java", "-jar", "EmployeeRecords.jar"]
