package com.websitemonitor.model;

public class Subscription implements Observer {
    private int subscriptionId;
    private String status;
    private Website website;
    private NotificationPreference preference;

    public Subscription(int subscriptionId, Website website, NotificationPreference preference) {
        this.subscriptionId = subscriptionId;
        this.status = "ACTIVE";
        this.website = website;
        this.preference = preference;
        this.website.registerObserver(this);
    }

    public void updateSubscription(String newStatus) {
        this.status = newStatus;
        System.out.println("Subscription " + subscriptionId + " updated to: " + status);
    }

    public void deleteSubscription() {
        this.status = "DELETED";
        this.website.removeObserver(this);
        System.out.println("Subscription " + subscriptionId + " deleted.");
    }

    @Override
    public void update(Website website) {
        if (!"ACTIVE".equals(status)) {
            return;
        }

        String message = "Update on " + website.getUrl()
                + " via " + preference.getChannel();
        Notification notification = new Notification(message);
        notification.sendNotification();
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
