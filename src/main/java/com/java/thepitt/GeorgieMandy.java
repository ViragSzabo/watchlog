package com.java.thepitt;

import java.time.LocalDate;

public class GeorgieMandy {
    private final Calendar calendar;
    private final Series series;

    public GeorgieMandy() {
        this.series = new Series("Georgie & Mandy’s First Marriage", "comedy");
        this.calendar = new Calendar(series);
        initializeCalendar();
    }

    private void initializeCalendar() {
        Season season1 = new Season("S1");

        this.series.addSeason(season1);

        season1.addEpisode(new Episode(1, "The 6:10 to Lubbock", LocalDate.of(2024,10,17), "", ""));
        season1.addEpisode(new Episode(2, "Some New York Nonsense", LocalDate.of(2024,10,24), "", ""));
        season1.addEpisode(new Episode(3, "Secrets, Lies and a Chunk of Change", LocalDate.of(2024,10,31), "", ""));
        season1.addEpisode(new Episode(4, "Todd's Mom", LocalDate.of(2024,11,7), "", ""));
        season1.addEpisode(new Episode(5, "Thanksgiving", LocalDate.of(2024,11,14), "", ""));
        season1.addEpisode(new Episode(6, "A Regular Samaritan", LocalDate.of(2024,12,5), "", ""));
        season1.addEpisode(new Episode(7, "An Old Mustang", LocalDate.of(2024,12,12), "", ""));
        season1.addEpisode(new Episode(8, "Diet Crap", LocalDate.of(2025,1,30), "", ""));
        season1.addEpisode(new Episode(9, "A Tire Convention and the Moral High Ground", LocalDate.of(2025,2,6), "", ""));
        season1.addEpisode(new Episode(10, "A House Divided", LocalDate.of(2025,2,13), "", ""));
        season1.addEpisode(new Episode(11, "Working for the Enemy", LocalDate.of(2025,2,20), "", ""));
        season1.addEpisode(new Episode(12, "Typhoid Georgie", LocalDate.of(2025,2,27), "", ""));
        season1.addEpisode(new Episode(13, "McAllister Auto Loves the Ladies", LocalDate.of(2025,3,6), "", ""));
        season1.addEpisode(new Episode(14, "A Sportsbook and a Breakup", LocalDate.of(2025,3,13), "", ""));
        season1.addEpisode(new Episode(15, "Goddess of the Music Store", LocalDate.of(2025,4,3), "", ""));
        season1.addEpisode(new Episode(16, "Baby Fight", LocalDate.of(2025,4,10), "", ""));
        season1.addEpisode(new Episode(17, "Two Idiots on a Dirt Bike", LocalDate.of(2025,4,17), "", ""));

        for(Episode episode : season1.getEpisodes()) {
            episode.setDuration(20);
        }

        this.calendar.addToCalendar(LocalDate.of(2025, 4, 3), 1, 2);
        this.calendar.addToCalendar(LocalDate.of(2025, 4, 10), 3);
        this.calendar.addToCalendar(LocalDate.of(2025, 4, 17), 4);
        this.calendar.addToCalendar(LocalDate.of(2025, 4, 24), 5);
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public Series getSeries() {
        return series;
    }
}