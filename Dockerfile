FROM openjdk:8-jre-alpine
ADD ./target/spring-boot-service-1-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx400m", "-jar", "/app/spring-boot-service-1-0.0.1-SNAPSHOT.jar"]
EXPOSE 8092