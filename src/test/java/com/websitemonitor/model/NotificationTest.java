package com.websitemonitor.model;

import org.junit.Test;

public class NotificationTest {

    @Test
    public void testSendNotification() {
        Notification n = new Notification("Test message");
        n.sendNotification();
    }
}
