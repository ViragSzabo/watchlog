package com.java.thepitt;

import java.time.LocalDate;

public class Friends {
    private final Series series;
    private final Calendar calendar;

    public Friends() {
        this.series = new Series("Friends", "comedy");
        this.calendar = new Calendar(this.series);
        initializeCalendar();
    }

    private void initializeCalendar() {
        int[][] episodesPerSeason = {{24}, {24}, {25}, {24}, {24}, {25}, {24}, {24}, {24}, {18}};
        for(int seasonNumber = 1; seasonNumber <= 10; seasonNumber++) {
            Season season = new Season(String.valueOf(seasonNumber));
            series.addSeason(season);

            int numberOfEpisodes = episodesPerSeason[seasonNumber - 1][0];
            int episodeYear = 1994 + seasonNumber - 1;

            if (seasonNumber == 10 && numberOfEpisodes > 10) {
                episodeYear = 2003;
            }

            for (int episodeNumber = 1; episodeNumber <= numberOfEpisodes; episodeNumber++) {
                if(seasonNumber == 10 && episodeNumber > 10) {
                    episodeYear = 2004;
                }

                LocalDate airDate = LocalDate.of(episodeYear, 9, 22).plusDays(episodeNumber - 1);

                Episode episode = new Episode(
                        episodeNumber,
                        "The One With...",
                        LocalDate.of(episodeYear, 9, 22),
                        "NA", "NA");

                season.addEpisode(episode);

                for(Episode ep : season.getEpisodes()) {
                    ep.setWatchTime(20);
                }

                calendar.addToCalendar(airDate, episodeNumber);
            }
        }
    }

    public Calendar getCalendar() { return this.calendar; }
}