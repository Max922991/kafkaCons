FROM openjdk:21-jdk-slim

COPY pom.xml /app/pom.xml
WORKDIR /app

RUN apt-get update && apt-get install -y maven && apt-get clean && apt-get autoremove

COPY src/ /app/src

RUN mvn package

CMD ["java", "-jar", "target/kafkaCons-0.0.1-SNAPSHOT.jar"]

