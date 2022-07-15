FROM openjdk:18-jdk-slim-buster

EXPOSE 8080

ADD config /config
ADD target/AAF-0.0.1-SNAPSHOT.jar AAF.jar
 
ENTRYPOINT ["java","-jar","AAF.jar"]  
