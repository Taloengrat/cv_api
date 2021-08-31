FROM openjdk:11

USER root

WORKDIR /usr/src/myapp

COPY src/main/resources/static/taloengrat_cv.pdf /usr/src/myapp/

EXPOSE 8080

ADD target/cv_api-0.0.1-SNAPSHOT.jar cv_api-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "cv_api-0.0.1-SNAPSHOT.jar" ]

