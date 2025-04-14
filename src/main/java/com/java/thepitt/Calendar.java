package com.java.thepitt;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/** Tracks episodes that have been watched for a specific series. */
public class Calendar {
    private final Map<LocalDate, List<Episode>> calendar;
    private final Series series;

    /** Constructs of Calendar for the given series. */
    public Calendar(Series series) {
        this.series = series;
        this.calendar = new HashMap<>();
    }

    /** Add episodes to the calendar on the specified date. */
    public void addToCalendar(LocalDate date, int... episodeNumbers) {
        calendar.putIfAbsent(date, new ArrayList<>());
        for (int number : episodeNumbers) {
            Episode episode = getEpisodeByNumber(number);
            if (episode != null) {
                calendar.get(date).add(episode);
            }
        }
    }

    /** Finds an episode by its number. */
    private Episode getEpisodeByNumber(int number) {
        for (Season season : series.getSeasons()) {
            for (Episode episode : season.getEpisodes()) {
                if (episode.getEpisodeNumber() == number) {
                    return episode;
                }
            }
        }
        return null;
    }

    /** Calculates the total watch time across all watched episodes. */
    public int getTotalWatchTime() {
        return calendar.values().stream()
                .flatMap(List::stream)
                .mapToInt(Episode::getDuration)
                .sum();
    }

    /** Calculates the average watch time per day. */
    public double getAverageWatchTimePerDay() {
        return !calendar.isEmpty() ? (double) getTotalWatchTime() / calendar.size() : 0;
    }

    /** Gets the total watch time for a given month and year. */
    public int getWatchTimeForMonth(int month, int year) {
        return calendar.entrySet().stream()
                .filter(entry -> entry.getKey().getMonthValue() == month && entry.getKey().getYear() == year)
                .flatMap(entry -> entry.getValue().stream())
                .mapToInt(Episode::getDuration)
                .sum();
    }

    /** Gets the watch time for each episode, including how many times it has been watched. */
    public StringBuilder getEpisodeWatchTime() {
        Map<Episode, Integer> episodeWatchCount = new HashMap<>();
        StringBuilder result = new StringBuilder();

        calendar.values().forEach(episodes ->
                episodes.forEach(episode ->
                        episodeWatchCount.put(episode, episodeWatchCount.getOrDefault(episode, 0) + 1)
                )
        );

        episodeWatchCount.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getKey().getEpisodeNumber()))
                .forEach(entry -> result.append("Episode: ")
                        .append(entry.getKey().getEpisodeTitle())
                        .append(" - Watched ")
                        .append(entry.getValue()).append(" times")
                        .append(" - Total Duration: ")
                        .append(entry.getKey().getDuration() * entry.getValue())
                        .append(" minutes\n"));
        return result;
    }

    /** Gets the total number of episodes watched. */
    public int getTotalEpisodesWatched() {
        return calendar.values().stream().mapToInt(List::size).sum();
    }

    /** Gets the number of episodes watched per month. */
    public Map<String, Integer> getEpisodesWatchedPerMonth() {
        Map<String, Integer> episodesPerMonth = new HashMap<>();
        for (Map.Entry<LocalDate, List<Episode>> entry : calendar.entrySet()) {
            String monthYear = entry.getKey().getMonth() + " " + entry.getKey().getYear();
            episodesPerMonth.put(monthYear, episodesPerMonth.getOrDefault(monthYear, 0) + entry.getValue().size());
        }
        return episodesPerMonth;
    }

    /** Gets the top 5 days with the most episodes watched. */
    public Map<LocalDate, Integer> getPeakWatchDays() {
        Map<LocalDate, Integer> peakWatchDays = new HashMap<>();
        for (Map.Entry<LocalDate, List<Episode>> entry : calendar.entrySet()) {
            peakWatchDays.put(entry.getKey(), entry.getValue().size());
        }

        return peakWatchDays.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}