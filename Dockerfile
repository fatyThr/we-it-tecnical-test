FROM openjdk:21-jdk

# Créez un répertoire d'application
WORKDIR /app

# Copiez le jar généré par Spring Boot
COPY target/we-it-project.jar /app
VOLUME /tmp
COPY artefacts/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
