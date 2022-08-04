package formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {
    private DateTimeFormatter dateTimeFormatter;
    private String datePattern;

    public LocalDateFormatter(String datePattern) {
        this.datePattern = datePattern;
        dateTimeFormatter = DateTimeFormatter.ofPattern(datePattern);
    }

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        try {
            return LocalDate.parse(text, DateTimeFormatter.ofPattern(datePattern));
        } catch (DateTimeException ex) {
            throw  new IllegalArgumentException("invalid date");
        }
    }

    @Override
    public String print(LocalDate date, Locale locale) {
        return date.format(dateTimeFormatter);
    }
}
