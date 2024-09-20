
FROM openjdk:17
COPY "./target/jarfact-checking-app.war" practico.war
ENTRYPOINT ["java","-war","practico.jar"]