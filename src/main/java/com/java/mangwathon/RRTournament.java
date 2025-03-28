package com.java.mangwathon;

import java.util.*;

public class RRTournament {

    public static void main(String[] args) {
        Player geri = new Player("Geri", Map.of(
                "Strength Training", 7,
                "Cardio Training", 1,
                "Stretching", 3,
                "Magic Training", 4,
                "Weapon Training", 4,
                "Combat Training", 1));

        Player dirk = new Player("Dirk Bookman", Map.of(
                "Strength Training", 1,
                "Cardio Training", 1,
                "Stretching", 1,
                "Magic Training", 1,
                "Weapon Training", 1,
                "Combat Training", 1));

        Player virag = new Player("Virag", Map.of(
                "Strength", 4,
                "Combat", 0,
                "Magic", 1,
                "Cardio", 0,
                "Weapon", 0,
                "Stretching", 3));

        Player rina = new Player("Rina", Map.of(
                "Strength Training", 2,
                "Cardio Training", 0,
                "Stretching", 0,
                "Magic Training", 3,
                "Weapon Training", 0,
                "Combat Training", 0));

        Player adel = new Player("Adel", Map.of(
                "Strength Training", 2,
                "Cardio Training", 5,
                "Stretching", 0,
                "Magic Training", 5,
                "Weapon Training", 0,
                "Combat Training", 2));

        Player fanni = new Player("Fanni", Map.of(
                "Strength Training", 6,
                "Cardio Training", 5,
                "Stretching", 2,
                "Magic Training", 4,
                "Weapon Training", 3,
                "Combat Training", 0));

        List<Player> players = List.of(geri, dirk, virag, rina, adel, fanni);
        Collections.shuffle(players);

        System.out.println("Round Robin Tournament:");
        for (int i = 0; i < players.size(); i += 2) {
            System.out.println(players.get(i).getName() + " vs. " + players.get(i + 1).getName());
        }

        System.out.println("\nTournament Results:");

        for (int i = 0; i < players.size(); i += 2) {
            Player player1 = players.get(i);
            Player player2 = players.get(i + 1);

            String winner = player1.compete(player2);
            if (winner.equals(player1.getName())) {
                System.out.println(player1.getName() + " wins over " + player2.getName());
            } else if (winner.equals(player2.getName())) {
                System.out.println(player2.getName() + " wins over " + player1.getName());
            } else {
                System.out.println("It's a tie between " + player1.getName() + " and " + player2.getName());
            }
        }

        System.out.println("\nFinal Standings:");

        players.sort(Comparator.comparingInt(Player::getTotalScore).reversed());
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getTotalScore() + " points");
        }
    }
}
