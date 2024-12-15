FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/challenge-agudinoz-betterware.jar /app/challenge-agudinoz-betterware.jar
CMD ["java", "-jar", "/app/challenge-agudinoz-betterware.jar"]