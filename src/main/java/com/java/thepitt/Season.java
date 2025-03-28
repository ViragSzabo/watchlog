package com.java.thepitt;

import java.util.ArrayList;
import java.util.List;

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

    public void displayEpisodes() {
        for (Episode episode : episodes) {
            System.out.println("S" + this.seasonNumber + "E" + episode.getEpisodeNumber() + ": " + episode.getEpisodeTitle());
        }
    }
}
