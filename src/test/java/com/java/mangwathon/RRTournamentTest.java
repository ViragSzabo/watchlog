package com.java.mangwathon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RRTournamentTest {
    public RRTournament tournament;
    public List<Player> players;

    @BeforeEach
    void setUp() {
        this.tournament = new RRTournament();
        players = List.of(
                new Player("Geri", Map.of(Skills.Strength, 7, Skills.Cardio, 1, Skills.Stretching, 3, Skills.Magic, 4, Skills.Weapon, 4, Skills.Combat, 1)),
                new Player("Dirk", Map.of(Skills.Strength, 1, Skills.Cardio, 1, Skills.Stretching, 1, Skills.Magic, 1, Skills.Weapon, 1, Skills.Combat, 1))
        );
    }

    @Test
    void testPlayersInitialization() {
        List<Player> testPlayers = RRTournament.getPlayers();
        assertNotNull(testPlayers);
        assertEquals(6, testPlayers.size()); // Ensure all six players are added
    }

    @Test
    void testTournamentExecution() {
        List<Player> testPlayers = RRTournament.getPlayers();
        for (int i = 0; i < testPlayers.size(); i++) {
            for (int j = i + 1; j < testPlayers.size(); j++) {
                Player player1 = testPlayers.get(i);
                Player player2 = testPlayers.get(j);
                player1.compete(player2);
            }
        }

        for (Player player : testPlayers) {
            assertTrue(player.getTotalScore() >= 0);
        }
    }

    @Test
    void testFinalStandingsSorting() {
        List<Player> testPlayers = new ArrayList<>(RRTournament.getPlayers());
        for (int i = 0; i < testPlayers.size(); i++) {
            for (int j = i + 1; j < testPlayers.size(); j++) {
                Player player1 = testPlayers.get(i);
                Player player2 = testPlayers.get(j);
                player1.compete(player2);
            }
        }

        testPlayers.sort(Comparator.comparingInt(Player::getTotalScore).reversed());

        for (int i = 1; i < testPlayers.size(); i++) {
            assertTrue(testPlayers.get(i - 1).getTotalScore() >= testPlayers.get(i).getTotalScore());
        }
    }

    @Test
    void testSinglePlayerTournament() {
        List<Player> singlePlayerList = List.of(new Player("Solo", Map.of(Skills.Strength, 10)));

        assertEquals(1, singlePlayerList.size());
        assertEquals(0, singlePlayerList.get(0).getTotalScore()); // No matches should mean 0 points
    }
}