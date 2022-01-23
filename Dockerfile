FROM openjdk:14.0.2-jdk
RUN mkdir -p /usr/app/
ENV PROJECT_HOME /usr/app/
COPY build/libs/untitled-0.0.1-SNAPSHOT.jar  $PROJECT_HOME/app.jar
WORKDIR $PROJECT_HOME
CMD ["java", "-jar", "./app.jar"]
EXPOSE 8081
