package com.websitemonitor.model;

import com.websitemonitor.strategy.ComparisonStrategy;
import com.websitemonitor.strategy.HtmlContentStrategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Website implements Subject {
    private String url;
    private String lastContent;
    private String lastChecked;
    private List<Observer> observers;
    private ComparisonStrategy strategy;

    public Website(String url) {
        this(url, new HtmlContentStrategy());
    }

    public Website(String url, ComparisonStrategy strategy) {
        this.url = url;
        this.lastContent = "";
        this.lastChecked = "Never";
        this.observers = new ArrayList<>();
        this.strategy = strategy;
    }

    public void setStrategy(ComparisonStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkForUpdates(String newContent) {
        lastChecked = new Date().toString();
        System.out.println("Checking " + url + "...");

        if (lastContent.equals("")) {
            lastContent = newContent;
            return;
        }

        if (!strategy.compare(lastContent, newContent)) {
            lastContent = newContent;
            notifyObservers();
        } else {
            System.out.println("No update on: " + url);
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Update detected on: " + url);
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public String getUrl() {
        return url;
    }

    public String getLastContent() {
        return lastContent;
    }
}
