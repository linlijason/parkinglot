FROM openjdk:8u201-jre-alpine3.9

ADD build/libs/parkinglot-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]