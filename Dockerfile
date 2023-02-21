FROM eclipse-temurin:17-jre-alpine
EXPOSE 8080
COPY ./boot/build/libs/boot-0.0.1-SNAPSHOT.jar /blogimg.jar
ENTRYPOINT ["java","-jar","/blogimg.jar"]

