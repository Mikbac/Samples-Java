package pl.samples.JodaTime;

import lombok.extern.log4j.Log4j2;
import org.joda.time.DateTimeFieldType;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;

/**
 * Created by MikBac on 15.11.2021
 */

@Log4j2
public class Main {

    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        log.info(currentDate);
        // 2021-11-15

        LocalTime currentTime = LocalTime.now();
        log.info(currentTime);
        // 21:21:39.703

        LocalDateTime currentDateAndTime = LocalDateTime.now();
        log.info(currentDateAndTime.toDateTime());
        // 2021-11-15T21:21:39.704+01:00

        log.info(currentDateAndTime.toLocalDate());
        // 2021-11-15

        log.info(currentDateAndTime.toLocalTime());
        // 21:21:39.704

        Instant instant = new Instant();
        log.info(Instant.now());
        // 2021-11-15T20:19:31.475Z

        int year = instant.get(DateTimeFieldType.year());
        log.info(year);
        // 2021

        int month = instant.get(DateTimeFieldType.monthOfYear());
        log.info(month);
        // 11

        int day = instant.get(DateTimeFieldType.dayOfMonth());
        log.info(day);
        // 15

        int hour = instant.get(DateTimeFieldType.hourOfDay());
        log.info(hour);
        // 20

        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        log.info(currentLocalDateTime.plusDays(2));
        // 2021-11-17T21:35:50.045
    }

}
