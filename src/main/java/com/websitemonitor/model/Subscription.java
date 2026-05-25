package com.websitemonitor.model;

public class Subscription {
    private int subscriptionId;
    private String status;
    private Website website;
    private NotificationPreference preference;

    public Subscription(int subscriptionId, Website website, NotificationPreference preference) {
        this.subscriptionId = subscriptionId;
        this.status = "ACTIVE";
        this.website = website;
        this.preference = preference;
    }

    public void updateSubscription(String newStatus) {
        this.status = newStatus;
        System.out.println("Subscription " + subscriptionId + " updated to: " + status);
    }

    public void deleteSubscription() {
        this.status = "DELETED";
        System.out.println("Subscription " + subscriptionId + " deleted.");
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public String getStatus() {
        return status;
    }

    public Website getWebsite() {
        return website;
    }

    public NotificationPreference getPreference() {
        return preference;
    }
}
