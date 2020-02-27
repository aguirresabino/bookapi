FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=target/bookapi.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["java", "-jar", "app.jar"]
