package com.websitemonitor.system;

import com.websitemonitor.model.Subscription;
import com.websitemonitor.model.Website;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
    }

    public void monitorAll() {
        Set<Website> activeWebsites = new HashSet<>();
        for (Subscription sub : subscriptions) {
            if (sub.getStatus().equals("ACTIVE")) {
                activeWebsites.add(sub.getWebsite());
            }
        }
        for (Website website : activeWebsites) {
            website.checkForUpdates();
        }
    }
}
