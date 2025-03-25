package com.stupidsquad.webapp.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class DateUtils {
    public static long convertToEpoch(String dateString) {
        try {
            if (dateString == null) {
                return -1L;
            }
            // Parse the date string into a LocalDate (yyyy-MM-dd)
            LocalDate localDate = LocalDate.parse(dateString);

            // Use the 'Europe/Paris' ZoneId which handles both CET and CEST
            ZoneId parisZone = ZoneId.of("Europe/Paris");

            // Convert LocalDate to ZonedDateTime at midnight in the Europe/Paris time zone
            ZonedDateTime zonedDateTime = localDate.atStartOfDay(parisZone);

            // Return the epoch timestamp in seconds
            return zonedDateTime.toEpochSecond();
        } catch (DateTimeParseException e) {
            // Handle parsing errors
            System.err.println("Invalid date format : " + e.getMessage());
            return -1L; // Return -1 or some other value to signify error
        }
    }
}
