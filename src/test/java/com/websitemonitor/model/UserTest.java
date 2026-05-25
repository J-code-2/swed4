package com.websitemonitor.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testCreateSubscription() {
        User user = new User(1, "Alice", "alice@example.com");
        Website site = new Website("https://example.com");
        NotificationPreference pref = new NotificationPreference("Daily", "Email");

        Subscription sub = user.createSubscription(site, pref);
        assertEquals(1, user.getSubscriptions().size());
        assertEquals("ACTIVE", sub.getStatus());
    }

    @Test
    public void testCancelSubscription() {
        User user = new User(1, "Alice", "alice@example.com");
        Website site = new Website("https://example.com");
        NotificationPreference pref = new NotificationPreference("Daily", "Email");

        Subscription sub = user.createSubscription(site, pref);
        user.cancelSubscription(sub.getSubscriptionId());
        assertEquals(0, user.getSubscriptions().size());
    }

    @Test
    public void testChangeSubscription() {
        User user = new User(1, "Alice", "alice@example.com");
        Website site = new Website("https://example.com");
        NotificationPreference pref = new NotificationPreference("Daily", "Email");

        Subscription sub = user.createSubscription(site, pref);
        user.changeSubscription(sub.getSubscriptionId(), "PAUSED");
        assertEquals("PAUSED", sub.getStatus());
    }
}
