package com.websitemonitor;

import com.websitemonitor.model.*;
import com.websitemonitor.strategy.*;
import com.websitemonitor.system.WebsiteMonitorSystem;

public class Main {
    public static void main(String[] args) {
        WebsiteMonitorSystem system = new WebsiteMonitorSystem();
        User user = new User(1, "Alice", "alice@example.com");

        Website site = new Website("https://example.com", new HtmlContentStrategy());
        Subscription sub = user.createSubscription(site, new NotificationPreference("Daily", "Email"));
        system.addSubscription(sub);

        System.out.println("\n--- First check ---");
        system.monitorAll("<html><body>Hello</body></html>");

        System.out.println("\n--- Same HTML, no update ---");
        system.monitorAll("<html><body>Hello</body></html>");

        System.out.println("\n--- HTML changed ---");
        system.monitorAll("<html><body>Hello World</body></html>");

        System.out.println("\n--- Text strategy: only tags changed ---");
        site.setStrategy(new TextContentStrategy());
        system.monitorAll("<html><body><b>Hello World</b></body></html>");

        System.out.println("\n--- Size strategy: content got shorter ---");
        site.setStrategy(new ContentSizeStrategy());
        system.monitorAll("<html>Hi</html>");
    }
}
