package com.mufcfintech.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Util {

    public static LocalDate convertStringDateToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, formatter);

    }

    public static boolean isOver35YearsOld (String strBirthDate) {
        LocalDate birthDate = convertStringDateToLocalDate(strBirthDate);
        LocalDate today =   LocalDate.now();
        long years = ChronoUnit.YEARS.between(birthDate, today);
        return years > 35;
    }
}
