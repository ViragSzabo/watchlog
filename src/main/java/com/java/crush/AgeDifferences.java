package com.java.crush;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AgeDifferences
{
    public Idol idol1 = new Idol("Hueningkai", LocalDate.of(2002,8,14));
    public Idol idol2 = new Idol("Soobin", LocalDate.of(2000,12,5));
    public Idol idol3 = new Idol("San", LocalDate.of(1999,10,7));
    public Idol idol4 = new Idol("Bang Chan", LocalDate.of(1997,10,3));
    public Idol idol5 = new Idol("Lee Know", LocalDate.of(1998,10,25));
    public Idol idol6 = new Idol("Changbin", LocalDate.of(1999,8,11));
    public Idol idol7 = new Idol("Hyunjin", LocalDate.of(2000, 3, 20));
    public Idol idol8 = new Idol("Han", LocalDate.of(2000, 9, 14));
    public Idol idol9 = new Idol("Felix", LocalDate.of(2000, 9, 15));
    public Idol idol10 = new Idol("Seungmin", LocalDate.of(2000, 9, 22));
    public Idol idol11 = new Idol("I.N", LocalDate.of(2001, 2, 8));
    public Idol idol12 = new Idol("Yeonjun", LocalDate.of(1999, 9, 13));
    public Idol idol13 = new Idol("Beomgyu", LocalDate.of(2001, 3, 13));
    public Idol idol14 = new Idol("Taehyun", LocalDate.of(2002, 2, 5));
    public Idol idol15 = new Idol("Hongjoong", LocalDate.of(1998, 11, 7));
    public Idol idol16 = new Idol("Seonghwa", LocalDate.of(1998, 4, 3));
    public Idol idol17 = new Idol("Yunho", LocalDate.of(1999, 3, 23));
    public Idol idol18 = new Idol("Yeosang", LocalDate.of(1999, 6, 15));
    public Idol idol19 = new Idol("Mingi", LocalDate.of(1999, 8, 9));
    public Idol idol20 = new Idol("Wooyoung", LocalDate.of(1999, 11, 26));
    public Idol idol21 = new Idol("Jongho", LocalDate.of(2000, 10, 12));

    public Fan fan = new Fan("Virag Szabo", LocalDate.of(1999,6,1));

    public Group group1 = new Group(1, "TxT");
    public Group group2 = new Group(2, "SKZ");
    public Group group3 = new Group(3, "ATEEZ");

    public Company company1 = new Company("BIGHIT MUSIC");
    public Company company2 = new Company("KQ Entertainment");
    public Company company3 = new Company("JYP Entertainment");

    public static void main(String[] args) {
        AgeDifferences ageDifferences = new AgeDifferences();
        ageDifferences.setUp();

        Idol[] idols = {
                ageDifferences.idol1, ageDifferences.idol2, ageDifferences.idol3, ageDifferences.idol4,
                ageDifferences.idol5, ageDifferences.idol6, ageDifferences.idol7, ageDifferences.idol8,
                ageDifferences.idol9, ageDifferences.idol10, ageDifferences.idol11, ageDifferences.idol12,
                ageDifferences.idol13, ageDifferences.idol14, ageDifferences.idol15, ageDifferences.idol16,
                ageDifferences.idol17, ageDifferences.idol18, ageDifferences.idol19, ageDifferences.idol20,
                ageDifferences.idol21
        };

        List<Idol> sortedIdols = ageDifferences.getIdolsSortedByBirthdayProximity();
        for (Idol idol : sortedIdols) {
            ageDifferences.printAgeDifference(idol);
        }
    }

    private void setUp() {
        this.company1.addGroup(group1);
        this.group1.addIdol(idol1);
        this.group1.addIdol(idol2);
        this.group1.addIdol(idol12);
        this.group1.addIdol(idol13);
        this.group1.addIdol(idol14);

        this.company2.addGroup(group2);
        this.group2.addIdol(idol4);
        this.group2.addIdol(idol5);
        this.group2.addIdol(idol6);
        this.group2.addIdol(idol7);
        this.group2.addIdol(idol8);
        this.group2.addIdol(idol9);
        this.group2.addIdol(idol10);
        this.group2.addIdol(idol11);

        this.company3.addGroup(group3);
        this.group3.addIdol(idol3);
        this.group3.addIdol(idol15);
        this.group3.addIdol(idol16);
        this.group3.addIdol(idol17);
        this.group3.addIdol(idol18);
        this.group3.addIdol(idol19);
        this.group3.addIdol(idol20);
        this.group3.addIdol(idol21);
    }

    private void printAgeDifference(Idol idol) {
        LocalDate fanBirthDate = fan.getBirthDate();
        LocalDate idolBirthDate = idol.getBirthDate();
        Period period;

        String olderOrYounger;

        if (idolBirthDate.isAfter(fanBirthDate)) {
            period = Period.between(fanBirthDate, idolBirthDate);
            olderOrYounger = "younger than";
        } else {
            period = Period.between(idolBirthDate, fanBirthDate);
            olderOrYounger = "older than";
        }

        System.out.printf(
                "%s is %d years, %d months, and %d days %s %s.%n",
                idol.getStageName(),
                period.getYears(),
                period.getMonths(),
                period.getDays(),
                olderOrYounger,
                fan.getFullName()
        );
    }

    private List<Idol> getIdolsSortedByBirthdayProximity() {
        LocalDate fanBirthday = fan.getBirthDate();
        MonthDay fanMonthDay = MonthDay.from(fanBirthday);

        Idol[] idols = {
                idol1, idol2, idol3, idol4, idol5, idol6, idol7, idol8,
                idol9, idol10, idol11, idol12, idol13, idol14, idol15,
                idol16, idol17, idol18, idol19, idol20, idol21
        };

        return Arrays.stream(idols)
                .sorted(Comparator.comparingInt(idol -> {
                    MonthDay idolMonthDay = MonthDay.from(idol.getBirthDate());
                    int daysDiff = (int) Math.abs(ChronoUnit.DAYS.between(
                            fanMonthDay.atYear(2000), idolMonthDay.atYear(2000)
                    ));
                    return daysDiff;
                }))
                .collect(Collectors.toList());
    }
}