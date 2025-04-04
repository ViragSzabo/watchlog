package com.java.mangwathon;

import java.util.*;

public class Player {

    private final String name;
    private final Map<Skills, Integer> stats;
    private int wins = 0;
    private int losses = 0;
    private int ties = 0;
    private static final int WIN_POINTS = 3;
    private static final int TIES_POINTS = 1;

    public Player(String name, Map<Skills, Integer> stats) {
        this.name = Objects.requireNonNull(name, "Player name cannot be null.");
        this.stats = Collections.unmodifiableMap(Objects.requireNonNull(stats, "Stats cannot be null."));
    }

    public String getName() {
        return name;
    }

    public int getStat(Skills statName) {
        return stats.getOrDefault(statName, 0);
    }

    public Map<Skills, Integer> getSkills() {
        return stats;
    }

    public void compete(Player other) {
        if (other == null) throw new IllegalArgumentException("Opponent cannot be null");

        int thisWins = 0, otherWins = 0;

        System.out.println("\n⚔️ Match: " + name + " vs " + other.getName());

        for (Skills skill : Skills.values()) {
            int thisStat = this.getStat(skill);
            int otherStat = other.getStat(skill);

            System.out.println(skill + ": " + thisStat + " vs " + otherStat);

            if (thisStat > otherStat) thisWins++;
            else if (thisStat < otherStat) otherWins++;
        }

        if (thisWins > otherWins) {
            this.wins++;
            other.losses++;
            System.out.println("🏆 " + name + " wins!");
        } else if (thisWins < otherWins) {
            other.wins++;
            this.losses++;
            System.out.println("🏆 " + other.getName() + " wins!");
        } else {
            this.ties++;
            other.ties++;
            System.out.println("🤝 It's a tie!");
        }
    }

    public int getTotalScore() {
        return (wins * WIN_POINTS) + (ties * TIES_POINTS);
    }

    public void printResults() {
        System.out.printf("%s | Wins: %d | Losses: %d | Ties: %d | Total Points: %d%n",
                name, wins, losses, ties, getTotalScore());
    }
}