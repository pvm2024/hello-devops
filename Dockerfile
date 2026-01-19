FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY . .
RUN javac App.java
EXPOSE 9090
CMD ["java", "App"]
