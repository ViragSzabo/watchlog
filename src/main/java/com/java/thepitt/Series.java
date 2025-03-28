package com.java.thepitt;

import java.util.ArrayList;
import java.util.List;

public class Series {

    private String title;
    private final List<Season> seasons;
    private String genre;

    public Series(String title, String genre) {
        this.title = title;
        this.seasons = new ArrayList<>();
        this.genre = genre;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addSeason(Season season) {
        this.seasons.add(season);
    }

    public void removeSeason(Season season) {
        this.seasons.remove(season);
    }

    public List<Season> getSeasons() {
        return this.seasons;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTotalEpisodes() {
        int totalEpisodes = 0;
        for (Season season : seasons) {
            totalEpisodes += season.getEpisodes().size();
        }
        return totalEpisodes;
    }

    public int getTotalSeasons() {
        return seasons.size();
    }

    public double calculateCompletionRate() {
        return (double) calculateTotalWatchedEpisodes() / getTotalEpisodes() * 100;
    }

    public int calculateTotalWatchedEpisodes() {
        int totalWatchedEpisodes = 0;
        for (Season season : seasons) {
            for (Episode episode : season.getEpisodes()) {
                if (episode.isWatched()) {
                    totalWatchedEpisodes++;
                }
            }
        }
        return totalWatchedEpisodes;
    }
}
