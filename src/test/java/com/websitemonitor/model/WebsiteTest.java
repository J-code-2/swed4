package com.websitemonitor.model;

import com.websitemonitor.strategy.HtmlContentStrategy;
import org.junit.Test;

import static org.junit.Assert.*;

public class WebsiteTest {

    @Test
    public void testCheckForUpdates() {
        Website site = new Website("https://example.com");
        site.checkForUpdates("<html>v1</html>");
        site.checkForUpdates("<html>v2</html>");
        assertEquals("<html>v2</html>", site.getLastContent());
        assertEquals("https://example.com", site.getUrl());
    }

    @Test
    public void testNoUpdateWhenHtmlIsSame() {
        Website site = new Website("https://example.com", new HtmlContentStrategy());
        site.checkForUpdates("<html>same</html>");
        site.checkForUpdates("<html>same</html>");
        assertEquals("<html>same</html>", site.getLastContent());
    }
}
