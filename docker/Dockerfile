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
RUN update-ms-fonts
RUN fc-cache -f
RUN rm -rf /var/cache/apk/*
WORKDIR /app
COPY ../alternative-courses-webapp/target/alternative-courses-webapp-1.0-SNAPSHOT.jar /app/webapp.jar
RUN ls -la
#EXPOSE 8080
ENTRYPOINT ["java", "-jar", "webapp.jar"]
