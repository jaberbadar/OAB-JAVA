FROM openjdk:17-jdk-slim
LABEL maintainer="abc@mail.com"
WORKDIR /app
EXPOSE 8080
COPY /target/emp-service.jar /app/emp-service.jar
ENTRYPOINT ["java", "-jar", "/app/emp-service.jar"]

