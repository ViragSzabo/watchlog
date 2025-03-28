package com.java.thepitt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class SeasonTest {

    private Season season1;
    private Episode e1, e2, e3;

    @BeforeEach
    public void setUp() {
        e1 = new Episode(1, "Episode 1", LocalDate.of(2025, 1, 1), "Writer 1", "Director 1");
        e2 = new Episode(2, "Episode 2", LocalDate.of(2025, 1, 2), "Writer 2", "Director 2");
        e3 = new Episode(3, "Episode 3", LocalDate.of(2025, 1, 3), "Writer 3", "Director 3");

        season1 = new Season(1, Arrays.asList(e1, e2, e3));
    }

    @Test
    public void testGetSeasonNumber() {
        assertEquals(1, season1.getSeasonNumber());
    }

    @Test
    public void testGetTotalDuration() {
        assertEquals(150, season1.getTotalDuration());  // 50 + 50 + 50
    }

    @Test
    public void testGetTotalWatchTime() {
        e1.setWatchTime(30);
        e2.setWatchTime(40);
        e3.setWatchTime(50);

        assertEquals(120, season1.getTotalWatchTime());  // 30 + 40 + 50
    }

    @Test
    public void testIsWatched() {
        assertFalse(season1.isWatched());  // No episodes are watched yet

        e1.setWatched(true);
        e2.setWatched(true);
        e3.setWatched(true);

        assertTrue(season1.isWatched());  // All episodes are watched
    }
}
