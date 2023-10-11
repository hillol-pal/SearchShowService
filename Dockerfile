FROM maven:3.6.3-jdk-11-slim AS build
WORKDIR /searchShowService
COPY src src
COPY pom.xml .
RUN mvn -f pom.xml clean package -Dmaven.test.skip=true

FROM openjdk:11-jre-slim-buster
ARG JAR_FILE=target/searchShowService-1.0.0.jar
COPY --from=build /searchShowService/${JAR_FILE} searchShowService-1.0.0.jar
ENTRYPOINT ["java","-jar","/searchShowService-1.0.0.jar"]