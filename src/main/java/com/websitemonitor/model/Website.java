package com.websitemonitor.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Website implements Subject {
    private String url;
    private String lastChecked;
    private List<Observer> observers;

    public Website(String url) {
        this.url = url;
        this.lastChecked = "Never";
        this.observers = new ArrayList<>();
    }

    public void checkForUpdates() {
        this.lastChecked = new Date().toString();
        System.out.println("Checking " + url + " for updates... Last checked: " + lastChecked);
        notifyObservers();
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
}
