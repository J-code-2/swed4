# Website Monitor

## Compile and run

```
javac -d out src/main/java/com/websitemonitor/model/*.java src/main/java/com/websitemonitor/strategy/*.java src/main/java/com/websitemonitor/system/*.java src/main/java/com/websitemonitor/Main.java
java -cp out com.websitemonitor.Main https://example.com
```

## Docker (Exercise 8, Task 3)

```
docker build -t website-monitor .
docker run --rm website-monitor https://example.com
```
