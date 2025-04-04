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
                new Player("Geri", Map.of(Skills.STRENGTH, 7, Skills.CARDIO, 1, Skills.STRETCHING, 3, Skills.MAGIC, 4, Skills.WEAPON, 4, Skills.COMBAT, 1)),
                new Player("Dirk", Map.of(Skills.STRENGTH, 1, Skills.CARDIO, 1, Skills.STRETCHING, 1, Skills.MAGIC, 1, Skills.WEAPON, 1, Skills.COMBAT, 1)),
                new Player("Virag", Map.of(Skills.STRENGTH, 4, Skills.CARDIO, 0, Skills.STRETCHING, 3, Skills.MAGIC, 1, Skills.WEAPON, 0, Skills.COMBAT, 0)),
                new Player("Rina", Map.of(Skills.STRENGTH, 2, Skills.CARDIO, 0, Skills.STRETCHING, 0, Skills.MAGIC, 3, Skills.WEAPON, 0, Skills.COMBAT, 0)),
                new Player("Adel", Map.of(Skills.STRENGTH, 2, Skills.CARDIO, 5, Skills.STRETCHING, 0, Skills.MAGIC, 5, Skills.WEAPON, 0, Skills.COMBAT, 2)),
                new Player("Fanni", Map.of(Skills.STRENGTH, 6, Skills.CARDIO, 5, Skills.STRETCHING, 2, Skills.MAGIC, 4, Skills.WEAPON, 3, Skills.COMBAT, 0)),
                new Player("Mithrillion", Map.of(Skills.STRENGTH, 5, Skills.CARDIO, 6, Skills.STRETCHING, 0, Skills.MAGIC, 0, Skills.WEAPON, 0, Skills.COMBAT, 0))
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
        assertEquals(7, player.getStat(Skills.STRENGTH));
        assertEquals(1, player.getStat(Skills.CARDIO));
        assertEquals(4, player.getStat(Skills.MAGIC));
    }

    @Test
    void compete_winScenario() {
        Player winner = players.get(0);
        Player loser = players.get(1);

        winner.compete(loser);

        assertEquals(3, winner.getTotalScore());
        assertEquals(0, loser.getTotalScore());
    }

    @Test
    void compete_tieScenario() {
        Player player1 = new Player("Hero", Map.of(Skills.STRENGTH, 3, Skills.CARDIO, 2));
        Player player2 = new Player("Villain", Map.of(Skills.STRENGTH, 3, Skills.CARDIO, 2));

        player1.compete(player2);

        assertEquals(1, player1.getTotalScore());
        assertEquals(1, player2.getTotalScore());
    }

    @Test
    void compete_lossScenario() {
        Player loser = players.get(1);  // Dirk
        Player winner = players.get(0); // Geri

        loser.compete(winner);

        assertEquals(3, winner.getTotalScore());
        assertEquals(0, loser.getTotalScore());
    }

    @Test
    void getTotalScore_multipleMatches() {
        Player player = new Player("Test", Map.of(Skills.STRENGTH, 5));

        Player weakerOpponent = new Player("Weak", Map.of(Skills.STRENGTH, 2));
        Player equalOpponent = new Player("Equal", Map.of(Skills.STRENGTH, 5));
        Player strongerOpponent = new Player("Strong", Map.of(Skills.STRENGTH, 7));

        player.compete(weakerOpponent);
        player.compete(equalOpponent);
        player.compete(strongerOpponent);

        assertEquals(4, player.getTotalScore());
    }
}