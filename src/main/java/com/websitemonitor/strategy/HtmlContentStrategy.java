package com.websitemonitor.strategy;

public class HtmlContentStrategy implements ComparisonStrategy {

    @Override
    public boolean compare(String oldContent, String newContent) {
        return oldContent.equals(newContent);
    }
}
