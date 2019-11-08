FROM openjdk:12-jdk-alpine
EXPOSE 8080

ARG JAR_FILE=build/libs/docs-tree-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} docs-tree.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/docs-tree.jar"]
