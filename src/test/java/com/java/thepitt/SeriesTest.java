package com.java.thepitt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {

    private Series series;
    private Season s1;
    private Episode e1, e2, e3;

    @BeforeEach
    public void setUp() {
        series = new Series("The Pitt", "Medical drama");
        s1 = new Season("Season 1");

        e1 = new Episode(1, "Episode 1", LocalDate.of(2025, 1, 1), "Writer 1", "Director 1");
        e2 = new Episode(2, "Episode 2", LocalDate.of(2025, 1, 2), "Writer 2", "Director 2");
        e3 = new Episode(3, "Episode 3", LocalDate.of(2025, 1, 3), "Writer 3", "Director 3");

        s1.addEpisode(e1);
        s1.addEpisode(e2);
        s1.addEpisode(e3);

        series.addSeason(s1);
    }

    @Test
    public void testGetTotalEpisodes() {
        assertEquals(3, series.getTotalEpisodes());  // 3 episodes in total
    }
}
