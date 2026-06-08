package com.websitemonitor.strategy;

public class ContentSizeStrategy implements ComparisonStrategy {

    @Override
    public boolean compare(String oldContent, String newContent) {
        return oldContent.length() == newContent.length();
    }
}
