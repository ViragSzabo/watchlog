package com.java.thepitt;

public class Contestants {
    private String name;
    private int age;
    private String occcupation;
    private final Season season;

    public Contestants(String name, int age, String occcupation, Season season) {
        this.name = name;
        this.age = age;
        this.occcupation = occcupation;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public Season getSeason() {
        return season;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOcccupation() {
        return occcupation;
    }

    public void setOcccupation(String occcupation) {
        this.occcupation = occcupation;
    }
}