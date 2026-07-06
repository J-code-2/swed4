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

## Unit tests (Exercise 9)

Compile the tests (requires JUnit in `lib/`):

```
javac -cp "out:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" -d out $(find src/test/java -name '*.java')
```

Run the equivalence-class tests for the website monitor:

```
java -cp "out:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore com.websitemonitor.WebsiteEquivalenceTest
```

Run all tests:

```
java -cp "out:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore com.websitemonitor.WebsiteEquivalenceTest com.websitemonitor.strategy.ComparisonStrategyTest com.websitemonitor.model.WebsiteTest
```