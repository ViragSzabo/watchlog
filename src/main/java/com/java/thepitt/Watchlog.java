package com.java.thepitt;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Watchlog {
    private final ThePitt thePitt;

    public Watchlog() {
        this.thePitt = new ThePitt();
    }

    public static void main(String[] args) {
        Watchlog wl = new Watchlog();

        int totalMinutes = wl.getThePitt().getCalendar().getTotalWatchTime();
        int totalHours = wl.getThePitt().getCalendar().getTotalWatchTime() / 60;

        NumberFormat formatter = NumberFormat.getInstance(Locale.FRANCE);

        System.out.println("=== The Pitt ===");
        System.out.println("=== Total Data ===");
        System.out.println("Total Episodes Watched: " + wl.getThePitt().getCalendar().getTotalEpisodesWatched());

        System.out.println("=== Total Watch Time ===");
        System.out.println("Total Time Watched: " + formatter.format(totalMinutes) + " minutes");
        System.out.println("Total Time Watched: " + formatter.format(totalHours) + " hours\n");

        System.out.println("=== Average Watch Time Per Day ===");
        System.out.println("Average Watch Time Per Day: " + Math.round(wl.getThePitt().getCalendar().getAverageWatchTimePerDay() / 60) + " hours\n");

        System.out.println("=== Watch Time For Specific Months ===");
        System.out.println("February 2025: " + wl.getThePitt().getCalendar().getWatchTimeForMonth(2, 2025) / 60 + " hours");
        System.out.println("March 2025: " + wl.getThePitt().getCalendar().getWatchTimeForMonth(3, 2025) / 60 + " hours");
        System.out.println("April 2025: " + wl.getThePitt().getCalendar().getWatchTimeForMonth(4, 2025) / 60 + " hours");
        System.out.println(wl.getThePitt().getCalendar().getEpisodesWatchedPerMonth() + "\n");

        System.out.println("=== Episode Watch Time ===");
        System.out.println(wl.getThePitt().getCalendar().getEpisodeWatchTime());

        System.out.println("=== Peak Watch Days ===");
        Map<LocalDate, Integer> peakDays = wl.getThePitt().getCalendar().getPeakWatchDays();
        Map<LocalDate, Integer> sortedPeakDays = peakDays.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        sortedPeakDays.forEach((date, count) -> System.out.println(date + ": " + count + " episodes watched"));
    }

    public ThePitt getThePitt() { return thePitt; }
}