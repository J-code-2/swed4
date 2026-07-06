package com.websitemonitor;

import com.websitemonitor.model.NotificationPreference;
import com.websitemonitor.model.Subscription;
import com.websitemonitor.model.Website;
import com.websitemonitor.strategy.ComparisonStrategy;
import com.websitemonitor.strategy.ContentSizeStrategy;
import com.websitemonitor.strategy.HtmlContentStrategy;
import com.websitemonitor.strategy.TextContentStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Exercise 9, Task 3: Equivalence classes for the Exercise 6 website monitor.
 *
 * Website.checkForUpdates partitions input into:
 * EC-W1: First check (no previous content) -> store baseline, no notification
 * EC-W2: Content considered equal by strategy -> no update
 * EC-W3: Content considered different by strategy -> update stored, observers notified
 *
 * Strategy-specific classes:
 * EC-S1 (ContentSize): same length vs different length
 * EC-S2 (Html): identical HTML vs different HTML
 * EC-S3 (Text): identical text (tags may differ) vs different text
 *
 * Subscription observer:
 * EC-O1: ACTIVE subscription reacts to updates
 * EC-O2: PAUSED subscription ignores updates
 */
public class WebsiteEquivalenceTest {

    private int notificationCount;

    @Before
    public void setUp() {
        notificationCount = 0;
    }

    private Website websiteWithStrategy(ComparisonStrategy strategy) {
        Website site = new Website("https://example.com", strategy);
        site.registerObserver(w -> notificationCount++);
        return site;
    }

    // --- EC-W1: first check ---

    @Test
    public void ecW1_firstCheckStoresBaselineWithoutNotification() {
        Website site = websiteWithStrategy(new HtmlContentStrategy());
        site.checkForUpdates("<html>v1</html>");
        assertEquals("<html>v1</html>", site.getLastContent());
        assertEquals(0, notificationCount);
    }

    // --- EC-S2 / EC-W2 / EC-W3: HTML strategy ---

    @Test
    public void ecS2_sameHtml_noUpdate() {
        Website site = websiteWithStrategy(new HtmlContentStrategy());
        site.checkForUpdates("<p>A</p>");
        site.checkForUpdates("<p>A</p>");
        assertEquals(0, notificationCount);
    }

    @Test
    public void ecS2_differentHtml_triggersUpdate() {
        Website site = websiteWithStrategy(new HtmlContentStrategy());
        site.checkForUpdates("<p>A</p>");
        site.checkForUpdates("<p>B</p>");
        assertEquals(1, notificationCount);
        assertEquals("<p>B</p>", site.getLastContent());
    }

    // --- EC-S3: text strategy ---

    @Test
    public void ecS3_sameTextDifferentTags_noUpdate() {
        Website site = websiteWithStrategy(new TextContentStrategy());
        site.checkForUpdates("<p>Hello</p>");
        site.checkForUpdates("<b>Hello</b>");
        assertEquals(0, notificationCount);
    }

    @Test
    public void ecS3_differentText_triggersUpdate() {
        Website site = websiteWithStrategy(new TextContentStrategy());
        site.checkForUpdates("<p>Hello</p>");
        site.checkForUpdates("<p>World</p>");
        assertEquals(1, notificationCount);
    }

    // --- EC-S1: content size strategy ---

    @Test
    public void ecS1_sameLengthDifferentContent_noUpdate() {
        Website site = websiteWithStrategy(new ContentSizeStrategy());
        site.checkForUpdates("abc");
        site.checkForUpdates("xyz");
        assertEquals(0, notificationCount);
    }

    @Test
    public void ecS1_differentLength_triggersUpdate() {
        Website site = websiteWithStrategy(new ContentSizeStrategy());
        site.checkForUpdates("abc");
        site.checkForUpdates("abcd");
        assertEquals(1, notificationCount);
    }

    // --- EC-O1 / EC-O2: subscription status ---

    @Test
    public void ecO1_activeSubscriptionNotifiedOnUpdate() {
        Website site = new Website("https://example.com", new HtmlContentStrategy());
        Subscription sub = new Subscription(1, site, new NotificationPreference("Daily", "Email"));
        site.checkForUpdates("<html>v1</html>");
        site.checkForUpdates("<html>v2</html>");
        assertEquals("ACTIVE", sub.getStatus());
    }

    @Test
    public void ecO2_pausedSubscriptionDoesNotChangeOnUpdate() {
        Website site = new Website("https://example.com", new HtmlContentStrategy());
        Subscription sub = new Subscription(1, site, new NotificationPreference("Daily", "Email"));
        sub.updateSubscription("PAUSED");
        site.checkForUpdates("<html>v1</html>");
        site.checkForUpdates("<html>v2</html>");
        assertEquals("PAUSED", sub.getStatus());
        assertEquals("<html>v2</html>", site.getLastContent());
    }
}
