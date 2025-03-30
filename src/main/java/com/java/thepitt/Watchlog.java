package com.java.thepitt;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

public class Watchlog {
    private final Calendar calendar;
    private final Series series;

    public Watchlog() {
        this.series = new Series("The Pitt", "Hospital Drama");
        this.calendar = new Calendar(series);
        initializeCalendar();
    }

    private void initializeCalendar() {
        Season season1 = new Season("1");
        this.series.addSeason(season1);

        season1.addEpisode(new Episode(1, "7AM", LocalDate.of(2025,1,9), "R. Scott Gemmill", "John Wells"));
        season1.addEpisode(new Episode(2, "8AM", LocalDate.of(2025,1,9), "R. Scott Gemmill", "Amanda Marsalis"));
        season1.addEpisode(new Episode(3, "9AM", LocalDate.of(2025,1,16), "R. Scott Gemmill & Joe Sachs", "Damian Marcano"));
        season1.addEpisode(new Episode(4, "10AM", LocalDate.of(2025,1,23), "Noah Wyle", "Amanda Marsalis"));
        season1.addEpisode(new Episode(5, "11AM", LocalDate.of(2025,1,30), "Simran Baidwan", "John Cameron"));
        season1.addEpisode(new Episode(6, "12PM", LocalDate.of(2025,2,6), "Cynthia Adarkwa", "Damian Marcano"));
        season1.addEpisode(new Episode(7, "1PM", LocalDate.of(2025,2,13), "Valerie Chu", "Silver Tree"));
        season1.addEpisode(new Episode(8, "2PM", LocalDate.of(2025,2,20), "Joe Sachs", "Amanda Marsalis"));
        season1.addEpisode(new Episode(9, "3PM", LocalDate.of(2025,2,27), "Noah Wyle", "Quyen Tran"));
        season1.addEpisode(new Episode(10, "4PM", LocalDate.of(2025,3,6), "Simran Baidwan", "Damian Marcano"));
        season1.addEpisode(new Episode(11, "5PM", LocalDate.of(2025,3,13), "Elyssa Gershman", "Quyen Tran"));
        season1.addEpisode(new Episode(12, "6PM", LocalDate.of(2025,3,20), "Joe Sachs & R. Scott Gemmill", "Amanda Marsalis"));
        season1.addEpisode(new Episode(13, "7PM", LocalDate.of(2025,3,27), "Joe Sachs & R. Scott Gemmill", "Damian Marcano"));
        season1.addEpisode(new Episode(14, "8PM", LocalDate.of(2025,4,3), "R. Scott Gemmill", "NA"));
        season1.addEpisode(new Episode(15, "9PM", LocalDate.of(2025,4,10), "R. Scott Gemmill", "NA"));

        calendar.addToCalendar(LocalDate.of(2025, 2, 22), 1, 2, 3, 4, 5, 6);
        calendar.addToCalendar(LocalDate.of(2025, 2, 23), 7, 8);
        calendar.addToCalendar(LocalDate.of(2025, 3, 1), 9, 1, 2, 3, 4);
        calendar.addToCalendar(LocalDate.of(2025, 3, 2), 5, 6, 7, 8, 9);
        calendar.addToCalendar(LocalDate.of(2025, 3, 7), 10);
        calendar.addToCalendar(LocalDate.of(2025, 3, 14), 11);
        calendar.addToCalendar(LocalDate.of(2025, 3, 21), 12);
        calendar.addToCalendar(LocalDate.of(2025, 3, 23), 1, 2, 3, 4, 5, 6, 7);
        calendar.addToCalendar(LocalDate.of(2025, 3, 24), 8, 9, 10);
        calendar.addToCalendar(LocalDate.of(2025, 3, 25), 11, 12);
        calendar.addToCalendar(LocalDate.of(2025, 3, 26), 1, 2, 3, 4, 5);
        calendar.addToCalendar(LocalDate.of(2025, 3, 27), 6, 7);
        calendar.addToCalendar(LocalDate.of(2025, 3, 28), 8, 9, 10, 11, 12, 13, 13);
    }

    public static void main(String[] args) {
        Watchlog wl = new Watchlog();

        int totalMinutes = wl.calendar.getTotalWatchTime();
        int totalHours = wl.calendar.getTotalWatchTime() / 60;

        NumberFormat formatter = NumberFormat.getInstance(Locale.FRANCE);

        System.out.println("=== Total Data ===");
        System.out.println("Total Episodes Watched: " + wl.calendar.getTotalEpisodesWatched());
        System.out.println("Most Watched Episodes: " + wl.calendar.getMostWatchedEpisode());

        System.out.println("=== Total Watch Time ===");
        System.out.println("Total Time Watched: " + formatter.format(totalMinutes) + " minutes");
        System.out.println("Total Time Watched: " + formatter.format(totalHours) + " hours\n");

        System.out.println("=== Average Watch Time Per Day ===");
        System.out.println("Average Watch Time Per Day: " + Math.round(wl.calendar.getAverageWatchTimePerDay() / 60) + " hours\n");

        System.out.println("=== Watch Time For Specific Months ===");
        System.out.println("February 2025: " + wl.calendar.getWatchTimeForMonth(2, 2025) / 60 + " hours");
        System.out.println("March 2025: " + wl.calendar.getWatchTimeForMonth(3, 2025) / 60 + " hours");
        System.out.println(wl.calendar.getEpisodesWatchedPerMonth() + "\n");

        System.out.println("=== Episode Watch Time ===");
        System.out.println(wl.calendar.getEpisodeWatchTime());

        System.out.println("=== Peak Watch Days ===");
        Map<LocalDate, Integer> peakDays = wl.calendar.getPeakWatchDays();
        peakDays.forEach((date, count) ->
                System.out.println(date + ": " + count + " episodes watched"));
    }
 }