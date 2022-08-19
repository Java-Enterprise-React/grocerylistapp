# build stage
FROM maven:3.6.0-jdk-11-slim AS build

#copy the pom.xml on my current machine, and put in the image at the location /home/app/pom.xml
COPY pom.xml /home/app/pom.xml

#copy the src folder on my current machine, and put in the image at the location /home/app/src
COPY src/ /home/app/src/

RUN mvn -f /home/app/pom.xml clean package


# run stage
FROM openjdk:11-jre-slim

COPY --from=build /home/app/target/grocerylistapp-1.0-SNAPSHOT-jar-with-dependencies.jar /home/app/app.jar

# Open port for use
EXPOSE 9000

ENTRYPOINT ["java", "-jar", "/home/app/app.jar"]




