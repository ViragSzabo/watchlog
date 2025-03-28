package com.example.watchlog;

import java.time.LocalDate;

public class Episode {

    private int episodeNumber;
    private String episodeTitle;
    private LocalDate publishedDate;
    private String writer;
    private String director;
    private int duration;
    private int watchTime;
    private int rewatchCount;
    private boolean watched;

    public Episode(int episodeNumber, String episodeTitle, LocalDate publishedDate, String writer, String director) {
        this.episodeNumber = episodeNumber;
        this.episodeTitle = episodeTitle;
        this.publishedDate = publishedDate;
        this.writer = writer;
        this.director = director;
        this.duration = 50;
        this.watchTime = 0;
        this.rewatchCount = 0;
        this.watched = false;
    }

    public int getEpisodeNumber() {
        return this.episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getEpisodeTitle() {
        return this.episodeTitle;
    }

    public void setEpisodeTitle(String episodeTitle) {
        this.episodeTitle = episodeTitle;
    }

    public LocalDate getPublishedDate() {
        return this.publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getWriter() {
        return this.writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getWatchTime() {
        return this.watchTime;
    }

    public void setWatchTime(int watchTime) {
        if (watchTime < 0) {
            throw new IllegalArgumentException("Watch time cannot be negative.");
        }
        this.watchTime = watchTime;
    }

    public int getRewatchCount() {
        return this.rewatchCount;
    }

    public void setRewatchCount(int rewatchCount) {
        this.rewatchCount = rewatchCount;
    }

    public boolean isWatched() {
        return this.watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public boolean isRewatched() {
        return this.rewatchCount > 0;
    }
}
