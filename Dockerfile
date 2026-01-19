FROM eclipse-temurin:17-jdk-slim
WORKDIR /app
COPY . .
RUN javac App.java
EXPOSE 9090
CMD ["java", "App"]
