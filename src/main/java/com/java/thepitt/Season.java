package com.java.thepitt;

import java.util.ArrayList;
import java.util.List;

public class Season {

    private String seasonNumber;
    private final List<Episode> episodes;
    private boolean isWatched;

    public Season(String seasonNumber) {
        this.seasonNumber = seasonNumber;
        this.episodes = new ArrayList<>();
        this.isWatched = false;
    }

    public String getSeasonNumber() {
        return this.seasonNumber;
    }

    public void setSeasonNumber(String seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public void addEpisode(Episode episode) {
        this.episodes.add(episode);
    }

    public void removeEpisode(Episode episode) {
        this.episodes.remove(episode);
    }

    public List<Episode> getEpisodes() {
        return this.episodes;
    }

    public boolean isWatched() {
        for (Episode episode : this.episodes) {
            if (!episode.isWatched()) {
                this.isWatched = false;
                return this.isWatched;

            }
        }
        this.isWatched = true;
        return this.isWatched;
    }

    public int calculateTotalWatchTime() {
        int totalWatchTime = 0;
        for (Episode episode : this.episodes) {
            totalWatchTime += episode.getWatchTime();
        }
        return totalWatchTime;
    }

    public double calculateAverageWatchTime() {
        return calculateTotalWatchTime() / this.episodes.size();
    }

    public void displayEpisodes() {
        for (Episode episode : episodes) {
            System.out.println("S" + this.seasonNumber + "E" + episode.getEpisodeNumber() + ": " + episode.getEpisodeTitle());
        }
    }
}
