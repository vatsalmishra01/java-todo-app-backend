FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY *.jar app.jar

EXPOSE 9200

ENTRYPOINT ["java", "-jar", "app.jar"]
