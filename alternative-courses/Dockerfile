FROM eclipse-temurin:17-jdk-alpine AS BUILD
COPY . /build/
WORKDIR /build/
RUN ls -la
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests
RUN ls -la

FROM eclipse-temurin:17-jre-alpine AS WEBAPP
# font apache poi
RUN apk update
RUN apk add tzdata
RUN apk add fontconfig
RUN apk add freetype
RUN apk add ttf-dejavu
RUN apk add msttcorefonts-installer
RUN cp /usr/share/zoneinfo/Mexico/General /etc/localtime
RUN date
RUN fc-cache -f
RUN rm -rf /var/cache/apk/*
WORKDIR /app
COPY --from=BUILD /build/alternative-courses-webapp/target/alternative-courses-webapp-1.0-SNAPSHOT.jar /app/webapp.jar
RUN ls -la
#EXPOSE 8080
ENTRYPOINT ["java", "-jar", "webapp.jar"]
