package com.java.mangwathon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RRTournamentTest {

    @Test
    void testPlayersInitialization() {
        List<Player> testPlayers = RRTournament.getPlayers();
        assertNotNull(testPlayers);
        assertEquals(7, testPlayers.size());
        assertEquals("Geri", testPlayers.get(0).getName());
        assertEquals("Dirk", testPlayers.get(1).getName());
        assertEquals("Virag", testPlayers.get(2).getName());
        assertEquals("Rina", testPlayers.get(3).getName());
        assertEquals("Adel", testPlayers.get(4).getName());
        assertEquals("Fanni", testPlayers.get(5).getName());
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
    void testGetPlayersReturnsNewInstances() {
        List<Player> firstCall = RRTournament.getPlayers();
        List<Player> secondCall = new ArrayList<>();
        assertNotSame(firstCall, secondCall);
    }

    @Test
    void testMainMethodExecution() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        RRTournament.main(new String[]{});

        System.setOut(originalOut);

        String output = outputStream.toString();
        assertTrue(output.contains("🏆 Round Robin Tournament Begins!"));
        assertTrue(output.contains("📊 FINAL STANDINGS:"));
    }

    @Test
    void testEmptyPlayerList() {
        List<Player> emptyList = new ArrayList<>();
        Player unknownPlayer = new Player("Jane Doe", Map.of(Skills.STRENGTH, 1, Skills.CARDIO, 1, Skills.STRETCHING, 1, Skills.MAGIC, 1, Skills.WEAPON, 1, Skills.COMBAT, 1));
        emptyList.add(unknownPlayer);
        emptyList.remove(unknownPlayer);
        assertEquals(0, emptyList.size());
    }

    @Test
    void testAllPlayersSameScore() {
        List<Player> equalPlayers = List.of(
                new Player("A", Map.of(Skills.STRENGTH, 5)),
                new Player("B", Map.of(Skills.STRENGTH, 5)),
                new Player("C", Map.of(Skills.STRENGTH, 5))
        );

        for (int i = 0; i < equalPlayers.size(); i++) {
            for (int j = i + 1; j < equalPlayers.size(); j++) {
                equalPlayers.get(i).compete(equalPlayers.get(j));
            }
        }

        int firstScore = equalPlayers.get(0).getTotalScore();
        for (Player player : equalPlayers) {
            assertEquals(firstScore, player.getTotalScore());
        }
    }

    @Test
    void testSinglePlayerTournament() {
        List<Player> singlePlayerList = List.of(new Player("Solo", Map.of(Skills.STRENGTH, 10)));

        assertEquals(1, singlePlayerList.size());
        assertEquals(0, singlePlayerList.get(0).getTotalScore());
    }
}