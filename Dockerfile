FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/chatbot-0.0.1-SNAPSHOT.jar /app/chatbot.jar
EXPOSE 8080
CMD ["java", "-jar", "chatbot.jar"]