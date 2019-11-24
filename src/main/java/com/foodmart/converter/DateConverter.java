package com.foodmart.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Json deserializers would be better practice if I was to serialize entity to json
 * instead of printing on the command line.
 */

public class DateConverter implements Converter<Date, String> {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public String convert(Date date) {
        return date != null ? SIMPLE_DATE_FORMAT.format(date): "";
    }
}
