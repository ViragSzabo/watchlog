package com.java.workout;

public class Exercise {
    private String name;
    private double met;
    private int reps;
    private double timeMinutes;

    public Exercise(String name, double met, int reps, double timeMinutes) {
        this.name = name;
        this.met = met;
        this.reps = reps;
        this.timeMinutes = timeMinutes;
    }

    public Exercise(String name, double met, double timeMinutes) {
        this.name = name;
        this.met = met;
        this.timeMinutes = timeMinutes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMet() {
        return met;
    }

    public void setMet(double met) { this.met = met; }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getTimeMinutes() {
        return timeMinutes;
    }

    public void setTimeMinutes(double timeMinutes) {
        this.timeMinutes = timeMinutes;
    }

    public double calculateCalories(double weightKg) {
        return met * weightKg * 3.5 / 200 * timeMinutes;
    }
}