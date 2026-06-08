package com.websitemonitor.strategy;

public class TextContentStrategy implements ComparisonStrategy {

    @Override
    public boolean compare(String oldContent, String newContent) {
        return getText(oldContent).equals(getText(newContent));
    }

    private String getText(String html) {
        return html.replaceAll("<[^>]+>", "");
    }
}
