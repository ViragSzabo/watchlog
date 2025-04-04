package com.java.mangwathon;

public enum Skills {
    STRENGTH("Strength", "Physical"),
    CARDIO("Cardio", "Endurance"),
    STRETCHING("Stretching", "Flexibility"),
    MAGIC("Magic", "Mystical"),
    WEAPON("Weapon", "Combat"),
    COMBAT("Combat", "Tactical");

    private final String displayName;
    private final String category;

    Skills(String displayName, String category) {
        this.displayName = displayName;
        this.category = category;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() { return displayName; }
}