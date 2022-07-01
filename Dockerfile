FROM openjdk:11
COPY . /app
WORKDIR /app
RUN ./gradlew build
CMD ["java", "-jar", "build/libs/rasp-api-java-1.0.0.jar"]
