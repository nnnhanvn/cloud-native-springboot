from eclipse-temurin:21
workdir workspace
arg JAR_FILE=target/*.jar
copy ${JAR_FILE} catalog-service.jar
entrypoint ["java", "-jar", "catalog-service.jar"]