package com.java.workout;

public class SizeEstimator {
    public static String getSize(double waist, double shoulders, Gender gender) {
        if (gender == Gender.FEMALE) {
            if (waist <= 60 && shoulders <= 38) return "XS";
            else if (waist <= 66 && shoulders <= 40) return "S";
            else if (waist <= 72 && shoulders <= 42) return "M";
            else if (waist <= 78 && shoulders <= 44) return "L";
            else return "XL";
        } else {
            if (waist <= 70 && shoulders <= 44) return "XS";
            else if (waist <= 76 && shoulders <= 46) return "S";
            else if (waist <= 82 && shoulders <= 48) return "M";
            else if (waist <= 88 && shoulders <= 50) return "L";
            else return "XL";
        }
    }
}