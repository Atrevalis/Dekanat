package com.dekanat.dekanat.server.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Time {
    public static LocalDate getLocalDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }
}
