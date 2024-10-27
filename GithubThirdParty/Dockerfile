
FROM maven:3.9.4-eclipse-temurin-17 AS build


WORKDIR /app


COPY pom.xml .
#COPY src/main/resources/META-INF/lib/ojdbc11-21.9.0.0.jar /app/lib/

RUN mvn dependency:go-offline
RUN mvn dependency:resolve


COPY src ./src

RUN mvn clean package -DskipTests





FROM eclipse-temurin:17-jre


WORKDIR /app


COPY --from=build /app/target/GithubThirdParty-0.0.1-SNAPSHOT.jar app.jar
#COPY --from=build /app/lib/ojdbc11-21.9.0.0.jar /app/lib/


EXPOSE 80


ENTRYPOINT ["java", "-jar", "app.jar"]
#ENTRYPOINT ["java", "-cp", "app.jar:lib/ojdbc11.jar", "com.ada.githubthirdparty.GithubThirdPartyApplication"]
