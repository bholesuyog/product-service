FROM openjdk:17

COPY target/product-service-image.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/product-service-image.jar"]