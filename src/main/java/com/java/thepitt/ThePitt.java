package com.java.thepitt;

import java.time.LocalDate;

public class ThePitt {

    public static void main(String[] args) {
        Season s1 = new Season("1");
        Episode e1 = new Episode(1, "7AM", LocalDate.of(2025, 1, 9), "R. Scott Gemmill", "John Wells");
        Episode e2 = new Episode(2, "8AM", LocalDate.of(2025, 1, 9), "R. Scott Gemmill", "Amanda Marsalis");
        Episode e3 = new Episode(3, "9AM", LocalDate.of(2025, 1, 16), "Joe Sachs & R. Scott Gemmill", "Damian Marcano");
        Episode e4 = new Episode(4, "10AM", LocalDate.of(2025, 1, 23), "Noah Wyle", "Amanda Marsalis");
        Episode e5 = new Episode(5, "11AM", LocalDate.of(2025, 1, 30), "John Cameron", "Simran Baidwan");
        Episode e6 = new Episode(6, "12PM", LocalDate.of(2025, 2, 6), "Damian Marcano", "Cynthia Adarkwa");
        Episode e7 = new Episode(7, "1PM", LocalDate.of(2025, 2, 13), "Valerie Chu", "Silver Tree");
        Episode e8 = new Episode(8, "2PM", LocalDate.of(2025, 2, 20), "Joe Sachs", "Amanda Marsalis");
        Episode e9 = new Episode(9, "3PM", LocalDate.of(2025, 2, 27), "Noah Wyle", "Simran Baidwan");
        Episode e10 = new Episode(10, "4PM", LocalDate.of(2025, 3, 6), "Damian Marcano", "Rachel Moore");
        Episode e11 = new Episode(11, "5PM", LocalDate.of(2025, 3, 13), "Quyen Tran", "Elyssa Gershman");
        Episode e12 = new Episode(12, "6PM", LocalDate.of(2025, 3, 20), "Joe Sachs & R. Scott Gemmill", "Amanda Marsalis");
        Episode e13 = new Episode(13, "7PM", LocalDate.of(2025, 3, 27), "Joe Sachs & R. Scott Gemmill", "Damian Marcano");
        Episode e14 = new Episode(14, "8PM", LocalDate.of(2025, 4, 3), "TBA", "Simran Baidwan");
        Episode e15 = new Episode(15, "9PM", LocalDate.of(2025, 4, 10), "TBA", "R. Scott Gemmill");

        s1.addEpisode(e1);
        s1.addEpisode(e2);
        s1.addEpisode(e3);
        s1.addEpisode(e4);
        s1.addEpisode(e5);
        s1.addEpisode(e6);
        s1.addEpisode(e7);
        s1.addEpisode(e8);
        s1.addEpisode(e9);
        s1.addEpisode(e10);
        s1.addEpisode(e11);
        s1.addEpisode(e12);
        s1.addEpisode(e13);
        s1.addEpisode(e14);
        s1.addEpisode(e15);

        s1.displayEpisodes();
    }
}
