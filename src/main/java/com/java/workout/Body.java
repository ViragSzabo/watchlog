package com.java.workout;

public class Body {
    private Gender gender;
    private double weight;
    private double height;
    private double waist;
    private double shoulders;
    private double muscleGained = 0.0;

    public Body(Gender gender, double weight, double height, double shoulders, double waist) {
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.shoulders = shoulders;
        this.waist = waist;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double startWeight) {
        this.weight = startWeight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double currentWeight) {
        this.height = currentWeight;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getShoulders() {
        return shoulders;
    }

    public void setShoulders(double shoulders) {
        this.shoulders = shoulders;
    }

    public double getMuscleGained() {
        return muscleGained;
    }

    public void gainMuscle(double gain) {
        muscleGained += gain;
    }

    public double getWeightLossWithoutPlateau() {
        return weight - height;
    }

    public double getCalculatedWaist() {
        double fatLoss = getWeightLossWithoutPlateau() - muscleGained;
        if (fatLoss < 0) fatLoss = 0;
        return waist - 0.5 * fatLoss;
    }

    public double getCalculatedShoulders() {
        double fatLoss = getWeightLossWithoutPlateau() - muscleGained;
        if (fatLoss < 0) fatLoss = 0;
        return shoulders + 0.1 * fatLoss + muscleGained * 2.0;
    }

    public void resetMuscleGained() {
        this.muscleGained = 0.0;
    }
}