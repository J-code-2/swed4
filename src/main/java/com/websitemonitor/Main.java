package com.websitemonitor;

import com.websitemonitor.model.*;
import com.websitemonitor.strategy.HtmlContentStrategy;
import com.websitemonitor.system.WebsiteMonitorSystem;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java -cp out com.websitemonitor.Main <website-url>");
            System.exit(1);
        }

        String websiteUrl = args[0];
        WebsiteMonitorSystem system = new WebsiteMonitorSystem();
        User user = new User(1, "Alice", "alice@example.com");

        Website site = new Website(websiteUrl, new HtmlContentStrategy());
        Subscription sub = user.createSubscription(site, new NotificationPreference("Daily", "Email"));
        system.addSubscription(sub);

        System.out.println("Monitoring website: " + websiteUrl);

        System.out.println("\n--- First check ---");
        system.monitorAll("<html><body>Hello</body></html>");

        System.out.println("\n--- Same content, no update ---");
        system.monitorAll("<html><body>Hello</body></html>");

        System.out.println("\n--- Content changed ---");
        system.monitorAll("<html><body>Hello World</body></html>");
    }
}
