package com.java.mangwathon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private List<Player> players;

    @BeforeEach
    void setUp() {
        players = List.of(
                new Player("Geri", Map.of(Skills.Strength, 7, Skills.Cardio, 1, Skills.Stretching, 3, Skills.Magic, 4, Skills.Weapon, 4, Skills.Combat, 1)),
                new Player("Dirk", Map.of(Skills.Strength, 1, Skills.Cardio, 1, Skills.Stretching, 1, Skills.Magic, 1, Skills.Weapon, 1, Skills.Combat, 1)),
                new Player("Virag", Map.of(Skills.Strength, 4, Skills.Cardio, 0, Skills.Stretching, 3, Skills.Magic, 1, Skills.Weapon, 0, Skills.Combat, 0)),
                new Player("Rina", Map.of(Skills.Strength, 2, Skills.Cardio, 0, Skills.Stretching, 0, Skills.Magic, 3, Skills.Weapon, 0, Skills.Combat, 0)),
                new Player("Adel", Map.of(Skills.Strength, 2, Skills.Cardio, 5, Skills.Stretching, 0, Skills.Magic, 5, Skills.Weapon, 0, Skills.Combat, 2)),
                new Player("Fanni", Map.of(Skills.Strength, 6, Skills.Cardio, 5, Skills.Stretching, 2, Skills.Magic, 4, Skills.Weapon, 3, Skills.Combat, 0))
        );
    }

    @Test
    void getName() {
        assertEquals("Geri", players.get(0).getName());
        assertEquals("Dirk", players.get(1).getName());
        assertEquals("Virag", players.get(2).getName());
        assertEquals("Rina", players.get(3).getName());
        assertEquals("Adel", players.get(4).getName());
        assertEquals("Fanni", players.get(5).getName());
    }

    @Test
    void getStat() {
        Player player = players.get(0);
        assertEquals(7, player.getStat(Skills.Strength));
        assertEquals(1, player.getStat(Skills.Cardio));
        assertEquals(4, player.getStat(Skills.Magic));
        assertEquals(0, player.getStat(null));  // Stat not provided, should return default 0
    }

    @Test
    void compete_winScenario() {
        Player winner = players.get(0); // Geri
        Player loser = players.get(1);  // Dirk

        winner.compete(loser);

        assertEquals(3, winner.getTotalScore()); // Win = 3 points
        assertEquals(0, loser.getTotalScore());  // Loss = 0 points
    }

    @Test
    void compete_tieScenario() {
        Player player1 = new Player("Hero", Map.of(Skills.Strength, 3, Skills.Cardio, 2));
        Player player2 = new Player("Villain", Map.of(Skills.Strength, 3, Skills.Cardio, 2));

        player1.compete(player2);

        assertEquals(1, player1.getTotalScore()); // Tie = 1 point
        assertEquals(1, player2.getTotalScore()); // Tie = 1 point
    }

    @Test
    void compete_lossScenario() {
        Player loser = players.get(1);  // Dirk
        Player winner = players.get(0); // Geri

        loser.compete(winner);

        assertEquals(3, winner.getTotalScore()); // Winner gets 3 points
        assertEquals(0, loser.getTotalScore());  // Loser stays at 0
    }

    @Test
    void getTotalScore_multipleMatches() {
        Player player = new Player("Test", Map.of(Skills.Strength, 5));

        Player weakerOpponent = new Player("Weak", Map.of(Skills.Strength, 2));
        Player equalOpponent = new Player("Equal", Map.of(Skills.Strength, 5));
        Player strongerOpponent = new Player("Strong", Map.of(Skills.Strength, 7));

        player.compete(weakerOpponent);  // Win (3 pts)
        player.compete(equalOpponent);   // Tie (1 pt)
        player.compete(strongerOpponent); // Loss (0 pts)

        assertEquals(4, player.getTotalScore()); // 3 + 1 + 0 = 4
    }
}