FROM openjdk:8
EXPOSE 8080
RUN mkdir -p /app/
ADD /build/libs/dummy-0.1.jar /app/dummy-0.1.jar
ENTRYPOINT ["java", "-jar", "/app/dummy-0.1.jar"]