package com.java.thepitt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class SeasonTest {

    private Season season1;
    private Episode e1, e2, e3;

    @BeforeEach
    public void setUp() {
        this.season1 = new Season("Season 1");
        this.e1 = new Episode(1, "Episode 1", LocalDate.of(2025, 1, 1), "Writer 1", "Director 1");
        this.e2 = new Episode(2, "Episode 2", LocalDate.of(2025, 1, 2), "Writer 2", "Director 2");
        this.e3 = new Episode(3, "Episode 3", LocalDate.of(2025, 1, 3), "Writer 3", "Director 3");

        this.season1.addEpisode(e1);
        this.season1.addEpisode(e2);
        this.season1.addEpisode(e3);
    }

    @Test
    public void testGetSeasonNumber() {
        assertEquals("Season 1", season1.getSeasonNumber()); // Season 1
    }

    @Test
    public void testGetEpisodes() {
        assertEquals(3, season1.getEpisodes().size()); // 3 episodes
    }
}
