package com.websitemonitor.model;

import java.util.Date;

public class Notification {
    private String message;
    private String date;

    public Notification(String message) {
        this.message = message;
        this.date = new Date().toString();
    }

    public void sendNotification() {
        System.out.println("Notification: " + message + " [" + date + "]");
    }
}
