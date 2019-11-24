package com.foodmart.converter;

import org.junit.Test;

import static org.junit.Assert.*;

public class SalaryConverterTest {

    private SalaryConverter salaryConverter = new SalaryConverter();

    @Test
    public void shouldFormatSalaryToBritishPounds() {
        assertEquals("£123", salaryConverter.convert(123));
        assertEquals("£1,234", salaryConverter.convert(1234));
        assertEquals("£12,345", salaryConverter.convert(12345));
        assertEquals("£123,456", salaryConverter.convert(123456));
    }

    @Test
    public void shouldNotThrownNullPointerIfSalaryIsMissing() {
        assertEquals("", salaryConverter.convert(null));
    }
}
