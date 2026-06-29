FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY src ./src
RUN mkdir -p out && \
    javac -d out \
    src/main/java/com/websitemonitor/model/*.java \
    src/main/java/com/websitemonitor/strategy/*.java \
    src/main/java/com/websitemonitor/system/*.java \
    src/main/java/com/websitemonitor/Main.java

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/out ./out
ENTRYPOINT ["java", "-cp", "out", "com.websitemonitor.Main"]
