package com.websitemonitor.system;

import com.websitemonitor.model.*;
import org.junit.Test;

public class WebsiteMonitorSystemTest {

    @Test
    public void testMonitorAll() {
        WebsiteMonitorSystem system = new WebsiteMonitorSystem();

        User user = new User(1, "Alice", "alice@example.com");
        Website site = new Website("https://example.com");
        NotificationPreference pref = new NotificationPreference("Daily", "Email");

        Subscription sub = user.createSubscription(site, pref);
        system.addSubscription(sub);

        system.monitorAll("<html>test</html>");
    }

    @Test
    public void testSkipsInactiveSubscription() {
        WebsiteMonitorSystem system = new WebsiteMonitorSystem();

        Website site = new Website("https://example.com");
        NotificationPreference pref = new NotificationPreference("Daily", "Email");
        Subscription sub = new Subscription(1, site, pref);
        sub.updateSubscription("PAUSED");

        system.addSubscription(sub);
        system.monitorAll("<html>test</html>");
    }
}
