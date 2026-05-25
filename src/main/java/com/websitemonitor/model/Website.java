package com.websitemonitor.model;

import java.util.Date;

public class Website {
    private String url;
    private String lastChecked;

    public Website(String url) {
        this.url = url;
        this.lastChecked = "Never";
    }

    public void checkForUpdates() {
        this.lastChecked = new Date().toString();
        System.out.println("Checking " + url + " for updates... Last checked: " + lastChecked);
    }

    public String getUrl() {
        return url;
    }
}
