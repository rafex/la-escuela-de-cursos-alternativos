FROM gcr.io/swift-smoke-275301/alpine-jre-17:latest AS WEBAPP
WORKDIR /app
COPY ../artifact/webapp.jar /app/webapp.jar
RUN ls -la
#EXPOSE 8080
ENTRYPOINT ["java", "-jar", "webapp.jar"]
