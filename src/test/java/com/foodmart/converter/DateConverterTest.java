package com.foodmart.converter;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DateConverterTest {
    
    private DateConverter dateConverter = new DateConverter();

    @Test
    public void shouldConvertDateIntoUKFormat() {
        assertEquals("24/11/2019", dateConverter.convert(new Date(1574628046989L)));
    }

    @Test
    public void shouldNotThrowNullPointerIfDateIsNotProvided() {
        assertEquals("", dateConverter.convert(null));
    }
}
