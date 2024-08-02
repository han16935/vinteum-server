FROM gradle:7.6.1-jdk17 AS build
WORKDIR /app
COPY . /app
RUN gradle build -x test

FROM openjdk:17-ea-11-jdk-slim
COPY --from=build /app/build/libs/Vinteum-0.0.1-SNAPSHOT.jar app.jar
ENV TZ Asia/Seoul
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]