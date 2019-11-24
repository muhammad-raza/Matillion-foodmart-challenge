package com.foodmart.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Json deserializers would be better practice if I was to serialize entity to json
 * instead of printing on the command line.
 */

public class SalaryConverter implements Converter<Integer, String> {
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getCurrencyInstance(Locale.UK);

    static {
        NUMBER_FORMAT.setMaximumFractionDigits(0);
    }

    @Override
    public String convert(Integer salary) {
        return salary != null ? NUMBER_FORMAT.format(salary) : "";
    }
}
