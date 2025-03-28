package com.java.thepitt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {

    private Series series;
    private Season s1, s2;
    private Episode e1, e2, e3;

    @BeforeEach
    public void setUp() {
        this.series = new Series("The Pitt", "Medical drama");
        this.s1 = new Season("Season 1");
        this.s2 = new Season("Season 2");

        this.e1 = new Episode(1, "Episode 1", LocalDate.of(2025, 1, 1), "Writer 1", "Director 1");
        this.e2 = new Episode(2, "Episode 2", LocalDate.of(2025, 1, 2), "Writer 2", "Director 2");
        this.e3 = new Episode(3, "Episode 3", LocalDate.of(2025, 1, 3), "Writer 3", "Director 3");

        this.s1.addEpisode(e1);
        this.s1.addEpisode(e2);
        this.s1.addEpisode(e3);

        this.series.addSeason(s1);
        this.series.addSeason(s2);
    }

    @Test
    public void testGetTotalEpisodes() {
        assertEquals(3, series.getTotalEpisodes());  // 3 episodes in total
    }

    @Test
    public void testGetTitle() {
        assertEquals("The Pitt", series.getTitle());
        this.series.setTitle("The Hospital of Pittsburgh");
        assertEquals("The Hospital of Pittsburgh", series.getTitle());
        this.series.setTitle(""); // Test with empty title
        assertEquals("", series.getTitle());
    }

    @Test
    public void testGetSeasons() {
        assertEquals(2, series.getSeasons().size());
        assertEquals(2, series.getTotalSeasons());
    }

    @Test
    public void testRemoveSeason() {
        this.series.removeSeason(s2);
        assertEquals(1, series.getSeasons().size()); // Ensure the season is removed
    }

    @Test
    public void testEmptySeries() {
        Series emptySeries = new Series("Empty Show", "Drama");
        assertEquals(0, emptySeries.getTotalEpisodes()); // No episodes in empty series
        assertEquals(0, emptySeries.getSeasons().size()); // No seasons in empty series
    }

    @Test
    public void testGetGenre() {
        assertEquals("Medical drama", series.getGenre());
        this.series.setGenre("Medical Drama");
        assertEquals("Medical Drama", series.getGenre());
        this.series.setGenre(""); // Test with empty genre
        assertEquals("", series.getGenre());
    }

    @Test
    public void testCalculateCompletionRate() {
        this.e1.isWatched();
        assertEquals(33, series.calculateCompletionRate(), 0.0); // 100% completion rate for watched episodes

        this.series.removeSeason(s1);
        assertEquals(0.0, series.calculateCompletionRate(), 0.0); // 0% completion when no episodes
    }

    @Test
    public void testCalculateTotalWatchedEpisodes() {
        this.e1.isWatched();
        this.e2.isWatched();
        assertEquals(2, series.calculateTotalWatchedEpisodes()); // 2 episodes watched
    }

    @Test
    public void testAddSeason() {
        Season newSeason = new Season("Season 3");
        this.series.addSeason(newSeason);
        assertEquals(3, series.getSeasons().size()); // Now there should be 3 seasons
        assertEquals(3, series.getTotalEpisodes());
    }

    @Test
    public void testAddDuplicateSeason() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            this.series.addSeason(s1);
        });
        assertEquals("Season already exists", thrown.getMessage());
    }
}