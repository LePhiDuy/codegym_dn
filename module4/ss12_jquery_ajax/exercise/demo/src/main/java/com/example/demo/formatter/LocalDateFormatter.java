package com.example.demo.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {
    private String datePattern;
    private DateTimeFormatter dateTimeFormatter;

    public LocalDateFormatter(String datePattern) {
        this.datePattern = datePattern;
        dateTimeFormatter = DateTimeFormatter.ofPattern(datePattern);
    }

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        try {
            return LocalDate.parse(text, DateTimeFormatter.ofPattern(datePattern));
        } catch(DateTimeParseException dateTimeParseException) {
            throw new IllegalArgumentException("invalid date");
        }
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return object.format(dateTimeFormatter);
    }
}
