package com.java.thepitt;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

public class Watchlog {
    private final ThePitt thePitt;
    private final GeorgieMandy georgieMandy;

    public Watchlog() {
        this.thePitt = new ThePitt();
        this.georgieMandy = new GeorgieMandy();
    }

    public static void main(String[] args) {
        Watchlog wl = new Watchlog();

        System.out.println("=== George & Mandy ===");
        System.out.println("Total Time Watched: " + wl.georgieMandy.getCalendar().getTotalWatchTime() + " minutes");
        System.out.println("Total Episodes Watched: " + wl.georgieMandy.getCalendar().getTotalEpisodesWatched() + " episodes");
        System.out.println("April 2025: " + wl.georgieMandy.getCalendar().getWatchTimeForMonth(4, 2025) + " minutes\n");
        System.out.println("=============================================\n");

        int totalMinutes = wl.thePitt.getCalendar().getTotalWatchTime();
        int totalHours = wl.thePitt.getCalendar().getTotalWatchTime() / 60;

        NumberFormat formatter = NumberFormat.getInstance(Locale.FRANCE);

        System.out.println("=== The Pitt ===");
        System.out.println("Total Episodes Watched: " + wl.thePitt.getCalendar().getTotalEpisodesWatched());
        System.out.println("Total Time Watched: " + formatter.format(totalMinutes) + " minutes");
        System.out.println("Total Time Watched: " + formatter.format(totalHours) + " hours");
        System.out.println("Average Watch Time Per Day: " + Math.round(wl.thePitt.getCalendar().getAverageWatchTimePerDay() / 60) + " hours\n");

        System.out.println("=== Watch Time For Specific Months ===");
        System.out.println("February 2025: " + wl.thePitt.getCalendar().getWatchTimeForMonth(2, 2025) / 60 + " hours");
        System.out.println("March 2025: " + wl.thePitt.getCalendar().getWatchTimeForMonth(3, 2025) / 60 + " hours");
        System.out.println("April 2025: " + wl.thePitt.getCalendar().getWatchTimeForMonth(4, 2025) / 60 + " hours\n ");

        System.out.println("=== Episode Watch Time ===");
        System.out.println(wl.thePitt.getCalendar().getEpisodeWatchTime());

        System.out.println("=== Peak Watch Days ===");
        Map<LocalDate, Integer> peakDays = wl.thePitt.getCalendar().getPeakWatchDays();
        peakDays.forEach((date, count) -> System.out.println(date + ": " + count + " episodes watched"));
    }
}