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
                new Player("Geri", Map.of(Skills.STRENGTH, 7, Skills.CARDIO, 1, Skills.STRETCHING, 3, Skills.MAGIC, 4, Skills.WEAPON, 4, Skills.COMBAT, 1)),
                new Player("Dirk", Map.of(Skills.STRENGTH, 1, Skills.CARDIO, 1, Skills.STRETCHING, 1, Skills.MAGIC, 1, Skills.WEAPON, 1, Skills.COMBAT, 1)),
                new Player("Virag", Map.of(Skills.STRENGTH, 4, Skills.CARDIO, 0, Skills.STRETCHING, 3, Skills.MAGIC, 1, Skills.WEAPON, 0, Skills.COMBAT, 0)),
                new Player("Rina", Map.of(Skills.STRENGTH, 2, Skills.CARDIO, 0, Skills.STRETCHING, 0, Skills.MAGIC, 3, Skills.WEAPON, 0, Skills.COMBAT, 0)),
                new Player("Adel", Map.of(Skills.STRENGTH, 2, Skills.CARDIO, 5, Skills.STRETCHING, 0, Skills.MAGIC, 5, Skills.WEAPON, 0, Skills.COMBAT, 2)),
                new Player("Fanni", Map.of(Skills.STRENGTH, 6, Skills.CARDIO, 5, Skills.STRETCHING, 2, Skills.MAGIC, 4, Skills.WEAPON, 3, Skills.COMBAT, 0)),
                new Player("Mithrillion", Map.of(Skills.STRENGTH, 5, Skills.CARDIO, 6, Skills.STRETCHING, 0, Skills.MAGIC, 0, Skills.WEAPON, 0, Skills.COMBAT, 0))
        );
    }
}