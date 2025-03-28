package com.java.thepitt;

import java.util.*;

public class Season {

    private String seasonNumber;

    private final List<Episode> episodes;

    public Season(String seasonNumber) {
        this.seasonNumber = seasonNumber;
        this.episodes = new ArrayList<>();
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

    public int calculateTotalWatchTime() {
        int totalWatchTime = 0;
        for (Episode episode : episodes) {
            totalWatchTime += episode.getWatchTime();
        }
        return totalWatchTime;
    }

    public int calculateTotalRewatchCount() {
        int totalRewatchCount = 0;
        for (Episode episode : episodes) {
            totalRewatchCount += episode.getRewatchCount();
        }
        return totalRewatchCount;
    }

    public double calculateAverageWatchTime() {
        return calculateTotalWatchTime() / episodes.size();
    }

    public double calculateAverageRewatchCount() {
        return calculateTotalRewatchCount() / episodes.size();
    }

    public void displayEpisodes() {
        for (Episode episode : episodes) {
            System.out.println("S" + this.seasonNumber + "E" + episode.getEpisodeNumber() + ": " + episode.getEpisodeTitle());
        }
    }
}
