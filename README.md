# Website Monitor

A Java application that monitors websites for updates and notifies users.

## How to compile

```
javac -d out src/main/java/com/websitemonitor/model/*.java src/main/java/com/websitemonitor/system/*.java src/main/java/com/websitemonitor/Main.java
```

## How to run

```
java -cp out com.websitemonitor.Main
```

## How to run tests

```
javac -cp "out;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" -d out src/test/java/com/websitemonitor/model/*.java src/test/java/com/websitemonitor/system/*.java
```

```
java -cp "out;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore com.websitemonitor.model.UserTest com.websitemonitor.model.SubscriptionTest com.websitemonitor.model.WebsiteTest com.websitemonitor.model.NotificationTest com.websitemonitor.model.NotificationPreferenceTest com.websitemonitor.system.WebsiteMonitorSystemTest
```
