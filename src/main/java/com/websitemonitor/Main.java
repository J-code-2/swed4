package com.websitemonitor;

import com.websitemonitor.model.*;
import com.websitemonitor.system.WebsiteMonitorSystem;

public class Main {
    public static void main(String[] args) {
        WebsiteMonitorSystem system = new WebsiteMonitorSystem();

        User user = new User(1, "Alice", "alice@example.com");

        Website site = new Website("https://example.com");
        NotificationPreference pref = new NotificationPreference("Daily", "Email");

        Subscription sub = user.createSubscription(site, pref);
        system.addSubscription(sub);

        System.out.println("\n--- Monitoring ---");
        system.monitorAll();

        System.out.println("\n--- Changing preference ---");
        pref.changePreference("Weekly", "SMS");

        System.out.println("\n--- Monitoring again ---");
        system.monitorAll();

        System.out.println("\n--- Cancelling ---");
        user.cancelSubscription(sub.getSubscriptionId());
    }
}
