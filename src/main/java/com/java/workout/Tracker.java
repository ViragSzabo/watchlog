package com.java.workout;

public class Tracker {
    private final Body body;
    private final int days;
    private final double dailyIntake;
    private final double dailyBurn;

    private final double[] weeklyWorkoutCals;
    private double totalDeficit = 0.0;

    private int totalPushups = 0;
    private int totalSquats = 0;
    private int totalPlankSeconds = 0;

    public Tracker(Body body, int days, double dailyIntake, int monthlySteps) {
        this.body = body;
        this.days = days;
        this.dailyIntake = dailyIntake;

        if (dailyIntake <= 0) {
            throw new IllegalArgumentException("Invalid input: daily intake must be positive.");
        }

        double kcalPerStep = 0.05;
        double stepBurn = (monthlySteps * kcalPerStep) / 30.0;
        this.dailyBurn = 2000.0 + stepBurn;

        this.weeklyWorkoutCals = new double[(int) Math.ceil(days / 7.0)];
    }

    public void run() {
        for (int day = 1; day <= days; day++) {
            boolean isResetDay = (day - 1) % 4 == 0;
            int pushups = isResetDay ? 10 : 10 + 2 * ((day - 1) % 4);
            int squats  = isResetDay ? 10 : 10 + 3 * ((day - 1) % 4);
            int plank   = isResetDay ? 20 : 20 + 5 * ((day - 1) % 4);

            totalPushups += pushups;
            totalSquats += squats;
            totalPlankSeconds += plank;

            WorkoutDay workout = new WorkoutDay(pushups, squats, plank, body.getWeight());
            double workoutCals = workout.getWorkoutCalories(body.getWeight());
            double totalBurn = dailyBurn + workoutCals;
            double netDeficit = totalBurn - dailyIntake;

            weeklyWorkoutCals[(day - 1) / 7] += workoutCals;
            totalDeficit += netDeficit;
        }
    }

    public void printResults() {
        double totalKgLost = totalDeficit / 7700.0;
        double projectedWeight = body.getWeight() - totalKgLost;
        double bmi = BodyMetrics.calculateBMI(projectedWeight, body.getHeight());
        String bmiCategory = BodyMetrics.interpretBMI(bmi);

        Body projectedBody = new Body(body.getGender(), projectedWeight, body.getHeight(), body.getShoulders(), body.getWaist());
        Workout workout = new Workout(totalPushups, totalSquats, totalPlankSeconds);
        String size = SizeEstimator.getSize(projectedBody.getWaist(), projectedBody.getShoulders(), body.getGender());
        double totalWorkoutCalories = 0.0;
        for (double cals : weeklyWorkoutCals) {
            totalWorkoutCalories += cals;
        }

        System.out.printf("- Total pushups: %d%n", workout.getTotalPushups());
        System.out.printf("- Total squats: %d%n", workout.getTotalSquats());
        System.out.printf("- Total plank seconds: %d%n", workout.getTotalPlankSeconds());
        System.out.printf("- Total workout burn: %.1f kcal → ~%.3f kg lost%n", totalWorkoutCalories, totalWorkoutCalories / 7700);
        System.out.printf("- Total deficit: %.1f kcal → ~%.3f kg lost%n", totalDeficit, totalKgLost);
        System.out.printf("- Starting weight: %.1f kg → Projected weight: %.1f kg%n", body.getWeight(), projectedBody.getWeight());
        System.out.printf("- BMI is %.2f → %s%n", bmi, bmiCategory);
        System.out.printf("- Estimated clothing size: %s%n", size);
    }
}