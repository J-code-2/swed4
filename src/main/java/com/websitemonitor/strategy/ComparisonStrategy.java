package com.websitemonitor.strategy;

public interface ComparisonStrategy {
    boolean compare(String oldContent, String newContent);
}
