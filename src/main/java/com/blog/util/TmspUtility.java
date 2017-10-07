package com.blog.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

/**
 * Class work with timestamp format.
 * Test tool: http://www.cy-pr.com/tools/time/
 *
 * @author Sergii Manko
 */
public final class TmspUtility {
    /**
     * Function calculate timestamp with GMT timezone.
     *
     * @param timestamp long Date in timestamp
     * @param format    String Format of return value, for example 'dd/MM/yyyy'
     * @return String
     */
    public static String getDateString(final long timestamp, final String format) {
        final DateFormat date = new SimpleDateFormat(format);
        date.setTimeZone(TimeZone.getTimeZone("GMT"));
        return date.format(new java.util.Date(timestamp * 1000L));
    }

    /**
     * Function calculate timestamp with GMT timezone.
     *
     * @param format String Input format of value, for example 'dd/MM/yyyy'
     * @param value  String Value of date in format
     * @return long
     * @throws ParseException
     */
    public static long getTimestamp(final String format, final String value) {
        final DateFormat date = new SimpleDateFormat(format);
        date.setTimeZone(TimeZone.getTimeZone("GMT"));
        long result = 0;
        try {
            result = date.parse(value).getTime() / 1000L;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Current date and time in timestamp format.
     *
     * @return long
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis() / 1000L;
    }

    /**
     * Function calculate day of timestamp with GMT timezone
     *
     * @param timestamp long Date in timestamp
     * @return int
     */
    public static int getDay(final long timestamp) {
        final DateFormat date = new SimpleDateFormat("dd");
        date.setTimeZone(TimeZone.getTimeZone("GMT"));
        return Integer.parseInt(date.format(new java.util.Date(timestamp * 1000)));
    }

    /**
     * Function calculate month of timestamp with GMT timezone
     *
     * @param timestamp long Date in timestamp
     * @return int
     */
    public static int getMonth(final long timestamp) {
        final DateFormat date = new SimpleDateFormat("MM");
        date.setTimeZone(TimeZone.getTimeZone("GMT"));
        return Integer.parseInt(date.format(new java.util.Date(timestamp * 1000)));
    }

    /**
     * Function calculate year of timestamp with GMT timezone
     *
     * @param timestamp long Date in timestamp
     * @return int
     */
    public static int getYear(final long timestamp) {
        final DateFormat date = new SimpleDateFormat("yyyy");
        date.setTimeZone(TimeZone.getTimeZone("GMT"));
        return Integer.parseInt(date.format(new java.util.Date(timestamp * 1000)));
    }

    /**
     * Function calculate count of years of timestamp to now
     *
     * @param date String Date for count years
     * @return long
     */
    public static Integer getCountOfYears(final String date) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        final LocalDate oldDate = LocalDate.parse(date, dtf);
        final LocalDate newDate = LocalDate.now();
        return Math.toIntExact(ChronoUnit.YEARS.between(oldDate, newDate));
    }
}