package com.websitemonitor.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class NotificationPreferenceTest {

    @Test
    public void testChangePreference() {
        NotificationPreference pref = new NotificationPreference("Daily", "Email");
        pref.changePreference("Weekly", "SMS");
        assertEquals("SMS", pref.getChannel());
    }
}
