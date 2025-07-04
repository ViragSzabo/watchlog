package com.java.workout;

public class BodyMetrics {
    public static double calculateBMI(double weightKg, double heightCm) {
        double heightMeters = heightCm / 100.0;
        return weightKg / (heightMeters * heightMeters);
    }

    public static String interpretBMI(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25.0) return "Normal weight";
        else if (bmi < 30.0) return "Overweight";
        else return "Obese";
    }
}