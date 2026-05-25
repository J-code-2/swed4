package com.websitemonitor.system;

import com.websitemonitor.model.Notification;
import com.websitemonitor.model.Subscription;

import java.util.ArrayList;

public class WebsiteMonitorSystem {
    private ArrayList<Subscription> subscriptions;

    public WebsiteMonitorSystem() {
        this.subscriptions = new ArrayList<>();
    }

    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void monitorWebsite(Subscription subscription) {
        subscription.getWebsite().checkForUpdates();
        detectUpdate(subscription);
    }

    public void detectUpdate(Subscription subscription) {
        System.out.println("Update detected on: " + subscription.getWebsite().getUrl());
        notifyUser(subscription);
    }

    public void notifyUser(Subscription subscription) {
        String message = "Update on " + subscription.getWebsite().getUrl()
                + " via " + subscription.getPreference().getChannel();
        Notification notification = new Notification(message);
        notification.sendNotification();
    }

    public void monitorAll() {
        for (Subscription sub : subscriptions) {
            if (sub.getStatus().equals("ACTIVE")) {
                monitorWebsite(sub);
            }
        }
    }
}
