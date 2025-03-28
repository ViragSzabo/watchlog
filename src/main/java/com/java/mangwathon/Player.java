package com.java.mangwathon;

import java.util.*;

public class Player {

    private final String name;
    private final Map<String, Integer> stats;

    public Player(String name, Map<String, Integer> of) {
        this.name = name;
        this.stats = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addStat(String statName, int value) {
        stats.put(statName, value);
    }

    public int getStat(String statName) {
        return stats.get(statName);
    }

    public void printStats() {
        System.out.println("Stats for " + name);
        for (String statName : stats.keySet()) {
            System.out.println(statName + ": " + stats.get(statName));
        }
    }

    public int getTotalScore() {
        return stats.values().stream().mapToInt(Integer::intValue).sum();
    }

    public String compete(Player other) {
        if (this.getTotalScore() > other.getTotalScore()) {
            return name + " wins!";
        } else if (getTotalScore() < other.getTotalScore()) {
            return other.getName() + " wins!";
        } else {
            return "It's a tie!";
        }
    }
}
