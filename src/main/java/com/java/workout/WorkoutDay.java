package com.java.workout;

public class WorkoutDay {
    private Exercise pushups;
    private Exercise squats;
    private Exercise plank;

    public WorkoutDay(int pushupReps, int squatReps, int plankSeconds, double weightKg) {
        this.pushups = new Exercise("Pushups", 8.0, pushupReps, 20.0);
        this.squats = new Exercise("Squats", 5.0, squatReps, 20.0);
        this.plank = new Exercise("Plank", 3.0, plankSeconds / 60.0);
    }

    public double getWorkoutCalories(double weightKg) {
        return pushups.calculateCalories(weightKg)
                + squats.calculateCalories(weightKg)
                + plank.calculateCalories(weightKg);
    }

    public Exercise getPushups() {
        return pushups;
    }

    public void setPushups(Exercise pushups) {
        this.pushups = pushups;
    }

    public Exercise getSquats() {
        return squats;
    }

    public void setSquats(Exercise squats) {
        this.squats = squats;
    }

    public Exercise getPlank() {
        return plank;
    }

    public void setPlank(Exercise plank) {
        this.plank = plank;
    }
}