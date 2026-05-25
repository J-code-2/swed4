package com.websitemonitor.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class SubscriptionTest {

    @Test
    public void testUpdateSubscription() {
        Website site = new Website("https://example.com");
        NotificationPreference pref = new NotificationPreference("Daily", "Email");
        Subscription sub = new Subscription(1, site, pref);

        sub.updateSubscription("PAUSED");
        assertEquals("PAUSED", sub.getStatus());
    }

    @Test
    public void testDeleteSubscription() {
        Website site = new Website("https://example.com");
        NotificationPreference pref = new NotificationPreference("Daily", "Email");
        Subscription sub = new Subscription(1, site, pref);

        sub.deleteSubscription();
        assertEquals("DELETED", sub.getStatus());
    }
}
