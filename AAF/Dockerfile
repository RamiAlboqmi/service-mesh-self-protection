FROM openjdk:17-jdk-slim-buster

EXPOSE 7070

ADD config /config
ADD target/rami-0.0.1-SNAPSHOT.jar rami.jar

ENTRYPOINT ["java","-jar","rami.jar"]