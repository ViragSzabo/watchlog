package com.java.workout;

public class Workout {
    private int totalPushups;
    private int totalSquats;
    private int totalPlankSeconds;

    public Workout(int totalPushups, int totalSquats, int totalPlankSeconds) {
        this.totalPushups = totalPushups;
        this.totalSquats = totalSquats;
        this.totalPlankSeconds = totalPlankSeconds;
    }

    public int getTotalPushups() {
        return totalPushups;
    }

    public void setTotalPushups(int totalPushups) {
        this.totalPushups = totalPushups;
    }

    public int getTotalSquats() {
        return totalSquats;
    }

    public void setTotalSquats(int totalSquats) {
        this.totalSquats = totalSquats;
    }

    public int getTotalPlankSeconds() {
        return totalPlankSeconds;
    }

    public void setTotalPlankSeconds(int totalPlankSeconds) {
        this.totalPlankSeconds = totalPlankSeconds;
    }
}