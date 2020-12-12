#https://medium.com/swlh/build-a-docker-image-using-maven-and-spring-boot-58147045a400
FROM openjdk:8
ARG JAR_FILE
ADD ${JAR_FILE} demo-1.jar
EXPOSE 8080
VOLUME /tmp
ENTRYPOINT ["java", "-jar", "/demo-1.jar"]