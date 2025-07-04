package com.java.thepitt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

public class Watchlog {
    public static final ThePitt thePitt = new ThePitt();
    public static final GeorgieMandy georgieMandy = new GeorgieMandy();
    public static final TheDevilsPlan theDevilsPlan = new TheDevilsPlan();
    private static final Logger log = LoggerFactory.getLogger(Watchlog.class);

    public static void main(String[] args) {
        try {
            System.out.println("Starting main...");

            showTheDevilsPlan();
            showGeorgieMandy();
            showThePitt();

            System.out.println("Listing contestants...");
            for (Contestants person : theDevilsPlan.getContestants()) {
                System.out.println(person.getName() + " is in " + person.getSeason());
            }

            System.out.println("Done.");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public static void showThePitt() {
        NumberFormat formatter = NumberFormat.getInstance(Locale.FRANCE);
        int totalMinutes = thePitt.getCalendar().getTotalWatchTime();
        int totalHours = totalMinutes / 60;

        System.out.println("=== The Pitt ===");
        System.out.println("Total Episodes Watched: " + thePitt.getCalendar().getTotalEpisodesWatched());
        System.out.println("Total Time Watched: " + formatter.format(totalMinutes) + " minutes");
        System.out.println("Total Time Watched: " + formatter.format(totalHours) + " hours");
        System.out.println("Average Watch Time Per Day: " +
                Math.round(thePitt.getCalendar().getAverageWatchTimePerDay() / 60.0) + " hours\n");

        System.out.println("=== Watch Time For Specific Months ===");
        System.out.println("February 2025: " + thePitt.getCalendar().getWatchTimeForMonth(2, 2025) / 60 + " hours");
        System.out.println("March 2025: " + thePitt.getCalendar().getWatchTimeForMonth(3, 2025) / 60 + " hours");
        System.out.println("April 2025: " + thePitt.getCalendar().getWatchTimeForMonth(4, 2025) / 60 + " hours\n");

        System.out.println("=== Episode Watch Time ===");
        System.out.println(thePitt.getCalendar().getEpisodeWatchTime());

        System.out.println("\n=== Peak Watch Days ===");
        Map<LocalDate, Integer> peakDays = thePitt.getCalendar().getPeakWatchDays();
        peakDays.forEach((date, count) ->
                System.out.println(date + ": " + count + " episodes watched")
        );
        System.out.println("=============================================\n");
    }

    public static void showGeorgieMandy() {
        System.out.println("=== George & Mandy ===");
        System.out.println("Total Time Watched: " + georgieMandy.getCalendar().getTotalWatchTime() + " minutes");
        System.out.println("Total Episodes Watched: " + georgieMandy.getCalendar().getTotalEpisodesWatched() + " episodes");
        System.out.println("April 2025: " + georgieMandy.getCalendar().getWatchTimeForMonth(4, 2025) + " minutes");
        System.out.println("=============================================\n");
    }

    public static void showTheDevilsPlan() {
        System.out.println("=== Devil's Plan ===");
        System.out.println("Total Time Watched: " + theDevilsPlan.getCalendar().getTotalWatchTime() + " minutes");
        System.out.println("Total Episodes Watched: " + theDevilsPlan.getCalendar().getTotalEpisodesWatched() + " episodes");
        System.out.println("Average Watch Time Per Day: " +
                Math.round(theDevilsPlan.getCalendar().getAverageWatchTimePerDay() / 60.0) + " hours");

        System.out.println("September 2023: " + theDevilsPlan.getCalendar().getWatchTimeForMonth(9, 2023) / 60 + " hours");
        System.out.println("October 2023: " + theDevilsPlan.getCalendar().getWatchTimeForMonth(10, 2023) / 60 + " hours");
        System.out.println("May 2025: " + theDevilsPlan.getCalendar().getWatchTimeForMonth(5, 2025) / 60 + " hours");
        System.out.println("=============================================\n");
    }
}