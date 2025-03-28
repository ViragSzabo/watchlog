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

    public List<Episode> getEpisodes() {
        return this.episodes;
    }

    public void addEpisode(Episode episode) {
        if (!this.episodes.contains(episode)) {
            this.episodes.add(episode);
        } else {
            throw new IllegalArgumentException("Episode already exists in this season");
        }
    }

    public void removeEpisode(Episode episode) {
        if(this.episodes.contains(episode)) {
            this.episodes.remove(episode);
        } else {
            throw new IllegalArgumentException("Episode does not exist in this season");
        }
    }

    public void displayEpisodes() {
        for (int i = 0; i < episodes.size(); i++) {
            Episode episode = episodes.get(i);
            System.out.print("S" + this.seasonNumber + "E" + episode.getEpisodeNumber() + ": " + episode.getEpisodeTitle());

            if (i < episodes.size() - 1) {
                System.out.println();
            }
        }
    }
}