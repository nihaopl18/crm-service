#FROM 192.168.251.157:1180/library/openjdk:8u111-jdk-alpine
FROM 192.168.251.157:1180/library/alpine-oraclejdk8:slim

VOLUME /tmp
ADD *.jar app.jar
ADD echain-studio echain-studio
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]