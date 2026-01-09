FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY HelloDevOps.java .
RUN javac HelloDevOps.java
EXPOSE 8080
CMD ["java", "HelloDevOps"]
