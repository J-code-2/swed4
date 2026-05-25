package com.websitemonitor.model;

import java.util.ArrayList;

public class User {
    private int userId;
    private String name;
    private String email;
    private ArrayList<Subscription> subscriptions;
    private int nextSubId = 1;

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.subscriptions = new ArrayList<>();
    }

    public Subscription createSubscription(Website website, NotificationPreference preference) {
        Subscription sub = new Subscription(nextSubId++, website, preference);
        subscriptions.add(sub);
        System.out.println(name + " subscribed to " + website.getUrl());
        return sub;
    }

    public void changeSubscription(int subscriptionId, String newStatus) {
        for (Subscription sub : subscriptions) {
            if (sub.getSubscriptionId() == subscriptionId) {
                sub.updateSubscription(newStatus);
                return;
            }
        }
        System.out.println("Subscription " + subscriptionId + " not found.");
    }

    public void cancelSubscription(int subscriptionId) {
        for (Subscription sub : subscriptions) {
            if (sub.getSubscriptionId() == subscriptionId) {
                sub.deleteSubscription();
                subscriptions.remove(sub);
                return;
            }
        }
        System.out.println("Subscription " + subscriptionId + " not found.");
    }

    public String getName() {
        return name;
    }

    public ArrayList<Subscription> getSubscriptions() {
        return subscriptions;
    }
}
