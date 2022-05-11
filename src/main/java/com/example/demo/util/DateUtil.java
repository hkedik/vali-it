package com.example.demo.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateUtil {

    public static String getFormattedDate(Instant timeStamp) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT )
                        .withLocale( Locale.FRANCE )
                        .withZone( ZoneId.systemDefault() );

        return formatter.format(timeStamp);
    }
}
