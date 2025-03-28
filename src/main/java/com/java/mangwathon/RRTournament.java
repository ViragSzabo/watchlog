package com.java.mangwathon;

import java.util.*;

public class RRTournament {

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>(getPlayers());

        System.out.println("🏆 Round Robin Tournament Begins!\n");

        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                Player player1 = players.get(i);
                Player player2 = players.get(j);
                displayMatchInfo(player1, player2);
                player1.compete(player2);
                System.out.println();
            }
        }

        System.out.println("\n📊 FINAL STANDINGS:");
        players.sort(Comparator.comparingInt(Player::getTotalScore).reversed());
        for (Player player : players) {
            player.printResults();
        }
    }

    public static void displayMatchInfo(Player player1, Player player2) {
        System.out.println("🔥 Match: " + player1.getName() + " vs " + player2.getName());
        System.out.println("Skills in competition: ");
        System.out.println(player1.getName() + "'s Skills: " + player1.getSkills());
        System.out.println(player2.getName() + "'s Skills: " + player2.getSkills());
        System.out.println("Let the competition begin!\n");
    }

    public static List<Player> getPlayers() {
        return List.of(
                new Player("Geri", Map.of(Skills.Strength, 7, Skills.Cardio, 1, Skills.Stretching, 3, Skills.Magic, 4, Skills.Weapon, 4, Skills.Combat, 1)),
                new Player("Dirk", Map.of(Skills.Strength, 1, Skills.Cardio, 1, Skills.Stretching, 1, Skills.Magic, 1, Skills.Weapon, 1, Skills.Combat, 1)),
                new Player("Virag", Map.of(Skills.Strength, 4, Skills.Cardio, 0, Skills.Stretching, 3, Skills.Magic, 1, Skills.Weapon, 0, Skills.Combat, 0)),
                new Player("Rina", Map.of(Skills.Strength, 2, Skills.Cardio, 0, Skills.Stretching, 0, Skills.Magic, 3, Skills.Weapon, 0, Skills.Combat, 0)),
                new Player("Adel", Map.of(Skills.Strength, 2, Skills.Cardio, 5, Skills.Stretching, 0, Skills.Magic, 5, Skills.Weapon, 0, Skills.Combat, 2)),
                new Player("Fanni", Map.of(Skills.Strength, 6, Skills.Cardio, 5, Skills.Stretching, 2, Skills.Magic, 4, Skills.Weapon, 3, Skills.Combat, 0)),
                new Player("Mithrillion", Map.of(Skills.Strength, 5, Skills.Cardio, 6, Skills.Stretching, 0, Skills.Magic, 0, Skills.Weapon, 0, Skills.Combat, 0))
        );
    }
}