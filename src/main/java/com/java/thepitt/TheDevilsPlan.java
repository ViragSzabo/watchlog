package com.java.thepitt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TheDevilsPlan {
    private final Calendar calendar;
    private final Series series;
    private final List<Contestants> contestants;
    private final Season season1;
    private final Season season2;

    public TheDevilsPlan() {
        this.series = new Series("The Devil's Plan", "game show");
        this.calendar = new Calendar(series);
        initializeCalendar();
        this.contestants = new ArrayList<>();

        season1 = new Season("S1");
        season2 = new Season("S2");


        Contestants s1p1 = new Contestants("Kwak Joon-bin (곽준빈)", 31, "YouTuber", season1);
        Contestants s1p2 = new Contestants("ORBIT (궤도)", 40, "Astronomer, Science Communicator, Blue House's former policy advisor", season1);
        Contestants s1p3 = new Contestants("Guillaume Party (기욤 패트리)", 41, "Esports Player", season1);
        Contestants s1p4 = new Contestants("Kim Dong-jae (김동재)", 24, "College student and pro poker player", season1);
        Contestants s1p5 = new Contestants("Park Kyeong-rim (박경림)", 44, "TV personality", season1);
        Contestants s1p6 = new Contestants("Seo Dong-joo (서동주)", 40, "US-based lawyer", season1);
        Contestants s1p7 = new Contestants("Seo Yoo-min (서유민)", 31, "American orthopedic surgeon", season1);
        Contestants s1p8 = new Contestants("Boo Seung-kwan (부승관)", 25, "Singer", season1);
        Contestants s1p9 = new Contestants("Lee Si-won (이시원)", 36, "Actress", season1);
        Contestants s1p10 = new Contestants("Lee Hye-sung (이혜성)", 30, "Freelance announcer", season1);
        Contestants s1p11 = new Contestants("Cheo Yeon-woo (조연우)", 34, "Professional Go Player", season1);
        Contestants s1p12 = new Contestants("Ha Seok-jin (하석진)", 41, "Actor", season1);

        Contestants s2p1 = new Contestants("Lee Sedol (이세돌)", 42, "Former Go Player", season2);
        Contestants s2p2 = new Contestants("Justin H. Min", 35, "Actor", season2);
        Contestants s2p3 = new Contestants("Cho Kyuhyun (규현)", 37, "Singer", season2);
        Contestants s2p4 = new Contestants("Kang Ji-young (강지영)", 31, "TV Presenter", season2);
        Contestants s2p5 = new Contestants("Yoon So-hee (윤소희)", 32, "Actress", season2);
        Contestants s2p6 = new Contestants("7high", 40, "Poker Player", season2);
        Contestants s2p7 = new Contestants("Lee Seung-hyun (이승현)", 35, "Miss Korea 2022", season2);
        Contestants s2p8 = new Contestants("Jeong Hyun-gyu (정현규)", 27, "Influencer", season2);
        Contestants s2p9 = new Contestants("Choi Hyun-joon (최현준)", 57, "Model", season2);
        Contestants s2p10 = new Contestants("Chuu (츄)", 26, "Singer", season2);
        Contestants s2p11 = new Contestants("Kim Ha-rin (김하린)", 37, "Plastic Surgeon", season2);
        Contestants s2p12 = new Contestants("Park Sang-yeon (박상연)", 52, "Physics Olympiad Gold Medallist", season2);
        Contestants s2p13 = new Contestants("Son Eun-yoo (손여은)", 42, "Mergers and Acquisitions Lawyer", season2);
        Contestants s2p14 = new Contestants("Tino (티노)", 40, "Board Games Master, YouTuber", season2);

        addContestant(s1p1);
        addContestant(s1p2);
        addContestant(s1p3);
        addContestant(s1p4);
        addContestant(s1p5);
        addContestant(s1p6);
        addContestant(s1p7);
        addContestant(s1p8);
        addContestant(s1p9);
        addContestant(s1p10);
        addContestant(s1p11);
        addContestant(s1p12);

        addContestant(s2p1);
        addContestant(s2p2);
        addContestant(s2p3);
        addContestant(s2p4);
        addContestant(s2p5);
        addContestant(s2p6);
        addContestant(s2p7);
        addContestant(s2p8);
        addContestant(s2p9);
        addContestant(s2p10);
        addContestant(s2p11);
        addContestant(s2p12);
        addContestant(s2p13);
        addContestant(s2p14);
    }

    private void initializeCalendar() {
        this.series.addSeason(season1);
        this.series.addSeason(season2);

        Episode s1e1 = new Episode(1, "Episode 1", LocalDate.of(2023,9,26), "", "");
        Episode s1e2 = new Episode(2, "Episode 2", LocalDate.of(2023,9,26), "", "");
        Episode s1e3 = new Episode(3, "Episode 3", LocalDate.of(2023,9,26), "", "");
        Episode s1e4 = new Episode(4, "Episode 4", LocalDate.of(2023,9,26), "", "");
        Episode s1e5 = new Episode(5, "Episode 5", LocalDate.of(2023,10,6), "", "");
        Episode s1e6 = new Episode(6, "Episode 6", LocalDate.of(2023,10,6), "", "");
        Episode s1e7 = new Episode(7, "Episode 7", LocalDate.of(2023,10,6), "", "");
        Episode s1e8 = new Episode(8, "Episode 8", LocalDate.of(2023,10,6), "", "");
        Episode s1e9 = new Episode(9, "Episode 9", LocalDate.of(2023,10,6), "", "");
        Episode s1e10 = new Episode(10, "Episode 10", LocalDate.of(2023,11,10), "", "");
        Episode s1e11 = new Episode(11, "Episode 11", LocalDate.of(2023,11,10), "", "");
        Episode s1e12 = new Episode(12, "Episode 12", LocalDate.of(2023,11,10), "", "");

        Episode s2e1 = new Episode(1, "Episode 1", LocalDate.of(2025,5,6), "", "");
        Episode s2e2 = new Episode(2, "Episode 2", LocalDate.of(2025,5,6), "", "");
        Episode s2e3 = new Episode(3, "Episode 3", LocalDate.of(2025,5,6), "", "");
        Episode s2e4 = new Episode(4, "Episode 4", LocalDate.of(2025,5,6), "", "");
        Episode s2e5 = new Episode(5, "Episode 5", LocalDate.of(2025,5,13), "", "");
        Episode s2e6 = new Episode(6, "Episode 6", LocalDate.of(2025,5,13), "", "");
        Episode s2e7 = new Episode(7, "Episode 7", LocalDate.of(2025,5,13), "", "");
        Episode s2e8 = new Episode(8, "Episode 8", LocalDate.of(2025,5,13), "", "");
        Episode s2e9 = new Episode(9, "Episode 9", LocalDate.of(2025,5,13), "", "");
        Episode s2e10 = new Episode(10, "Episode 10", LocalDate.of(2025,5,20), "", "");
        Episode s2e11 = new Episode(11, "Episode 11", LocalDate.of(2025,5,20), "", "");
        Episode s2e12 = new Episode(12, "Episode 12", LocalDate.of(2025,5,20), "", "");

        season1.addEpisode(s1e1);
        season1.addEpisode(s1e2);
        season1.addEpisode(s1e3);
        season1.addEpisode(s1e4);
        season1.addEpisode(s1e5);
        season1.addEpisode(s1e6);
        season1.addEpisode(s1e7);
        season1.addEpisode(s1e8);
        season1.addEpisode(s1e9);
        season1.addEpisode(s1e10);
        season1.addEpisode(s1e11);
        season1.addEpisode(s1e12);

        season2.addEpisode(s2e1);
        season2.addEpisode(s2e2);
        season2.addEpisode(s2e3);
        season2.addEpisode(s2e4);
        season2.addEpisode(s2e5);
        season2.addEpisode(s2e6);
        season2.addEpisode(s2e7);
        season2.addEpisode(s2e8);
        season2.addEpisode(s2e9);
        season2.addEpisode(s2e10);
        season2.addEpisode(s2e11);
        season2.addEpisode(s2e12);

        s1e1.setDuration(71);
        s1e2.setDuration(59);
        s1e3.setDuration(71);
        s1e4.setDuration(62);
        s1e5.setDuration(67);
        s1e6.setDuration(58);
        s1e7.setDuration(69);
        s1e8.setDuration(61);
        s1e9.setDuration(63);
        s1e10.setDuration(68);
        s1e11.setDuration(70);
        s1e12.setDuration(75);

        s2e1.setDuration(97);
        s2e2.setDuration(79);
        s2e3.setDuration(95);
        s2e4.setDuration(88);
        s2e5.setDuration(93);
        s2e6.setDuration(69);
        s2e7.setDuration(82);
        s2e8.setDuration(79);
        s2e9.setDuration(99);
        s2e10.setDuration(102);
        s2e11.setDuration(94);
        s2e12.setDuration(101);

        this.calendar.addToCalendar(LocalDate.of(2023, 9, 26), 1, 2, 3, 4);
        this.calendar.addToCalendar(LocalDate.of(2023, 10, 6), 5, 6, 7, 8, 9);
        this.calendar.addToCalendar(LocalDate.of(2023, 10, 10), 10, 11, 12);
        this.calendar.addToCalendar(LocalDate.of(2023, 10, 20), 1, 2, 3, 4, 5);
        this.calendar.addToCalendar(LocalDate.of(2023, 10, 21), 6, 7, 8, 9, 10);
        this.calendar.addToCalendar(LocalDate.of(2023, 10, 22), 11, 12);
        this.calendar.addToCalendar(LocalDate.of(2025, 5, 7), 1, 2, 3, 4);
        this.calendar.addToCalendar(LocalDate.of(2025, 5, 8), 1, 2);
        this.calendar.addToCalendar(LocalDate.of(2025, 5, 10), 3,4);
        this.calendar.addToCalendar(LocalDate.of(2025, 5, 13), 5,6,7,8,9);
        this.calendar.addToCalendar(LocalDate.of(2025, 5, 13), 1);
        this.calendar.addToCalendar(LocalDate.of(2025, 5, 20), 10,11,12);
        this.calendar.addToCalendar(LocalDate.of(2025, 5, 21), 12);
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public Series getSeries() {
        return series;
    }

    public List<Contestants> getContestants() { return contestants; }

    public void addContestant(Contestants contestants) { this.contestants.add(contestants); }
}