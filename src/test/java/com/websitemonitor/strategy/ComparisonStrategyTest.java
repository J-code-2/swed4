package com.websitemonitor.strategy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComparisonStrategyTest {

    @Test
    public void testContentSize() {
        ComparisonStrategy strategy = new ContentSizeStrategy();
        assertTrue(strategy.compare("abc", "xyz"));
        assertFalse(strategy.compare("abc", "abcd"));
    }

    @Test
    public void testHtmlContent() {
        ComparisonStrategy strategy = new HtmlContentStrategy();
        assertTrue(strategy.compare("<p>A</p>", "<p>A</p>"));
        assertFalse(strategy.compare("<p>A</p>", "<p>B</p>"));
    }

    @Test
    public void testTextContent() {
        ComparisonStrategy strategy = new TextContentStrategy();
        assertTrue(strategy.compare("<p>Hello</p>", "<b>Hello</b>"));
        assertFalse(strategy.compare("<p>Hello</p>", "<p>World</p>"));
    }
}
