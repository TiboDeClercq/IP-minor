package be.tibo.taskmanager.domain;

import java.util.Locale;
import java.text.ParseException;
import java.time.LocalDateTime;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;


@Component
public class TimeFormatter implements Formatter<LocalDateTime> {
    @Override
    public String print(LocalDateTime object, Locale locale) {
        return object.format(java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Override
    public LocalDateTime parse(String text, Locale locale) throws ParseException {
        return LocalDateTime.parse(text, java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
