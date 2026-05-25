package com.websitemonitor.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class WebsiteTest {

    @Test
    public void testCheckForUpdates() {
        Website site = new Website("https://example.com");
        site.checkForUpdates();
        assertEquals("https://example.com", site.getUrl());
    }
}
