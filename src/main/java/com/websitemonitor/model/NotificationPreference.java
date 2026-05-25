package com.websitemonitor.model;

public class NotificationPreference {
    private String frequency;
    private String channel;

    public NotificationPreference(String frequency, String channel) {
        this.frequency = frequency;
        this.channel = channel;
    }

    public void changePreference(String frequency, String channel) {
        this.frequency = frequency;
        this.channel = channel;
        System.out.println("Preference changed to: " + frequency + " via " + channel);
    }

    public String getChannel() {
        return channel;
    }
}
