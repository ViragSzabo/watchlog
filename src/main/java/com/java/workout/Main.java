package com.java.workout;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Workout Plan ===");
        Body myBody = new Body(
                Gender.FEMALE,
                166.0,
                80.0,
                41.0,
                39.0);
        Tracker tracker = new Tracker(myBody, 41, 1200, 100_000);
        tracker.run();
        tracker.printResults();
    }
}