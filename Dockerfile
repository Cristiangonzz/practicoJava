
FROM openjdk:17
COPY "./target/Slack-Call-Alert-0.0.1-SNAPSHOT.jar" slack-call.jar
ENTRYPOINT ["java","-jar","slack-call.jar"]