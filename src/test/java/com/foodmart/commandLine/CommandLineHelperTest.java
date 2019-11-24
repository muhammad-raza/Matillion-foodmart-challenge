package com.foodmart.commandLine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static com.foodmart.commandLine.CommandLineHelper.*;
import static org.junit.Assert.*;

public class CommandLineHelperTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void verifyDepartmentListContainsExpectedValues() {
        assertTrue(DEPARTMENTS.contains("HQ General Management"));
        assertTrue(DEPARTMENTS.contains("HQ Information Systems"));
        assertTrue(DEPARTMENTS.contains("HQ Marketing"));
        assertTrue(DEPARTMENTS.contains("HQ Human Resources"));
        assertTrue(DEPARTMENTS.contains("HQ Finance and Accounting"));
        assertTrue(DEPARTMENTS.contains("Store Management"));
        assertTrue(DEPARTMENTS.contains("Store Information Systems"));
        assertTrue(DEPARTMENTS.contains("Permanent Checkers"));
        assertTrue(DEPARTMENTS.contains("Temp Checkers"));
        assertTrue(DEPARTMENTS.contains("Permanent Stockers"));
        assertTrue(DEPARTMENTS.contains("Temp Stockers"));
        assertTrue(DEPARTMENTS.contains("Store Permanent Butchers"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void verifyDepartmentListIsImmutable() {
        DEPARTMENTS.add("something");
    }

    @Test
    public void verifyPayTypeListContainsExpectedValues() {
        assertTrue(PAY_TYPES.contains("Monthly"));
        assertTrue(PAY_TYPES.contains("Hourly"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void verifyPayTypeListIsImmutable() {
        PAY_TYPES.add("something");
    }

    @Test
    public void verifyEducationLevelListContainsExpectedValues() {
        assertTrue(EDUCATION_LEVEL.contains("Bachelors Degree"));
        assertTrue(EDUCATION_LEVEL.contains("Graduate Degree"));
        assertTrue(EDUCATION_LEVEL.contains("High School Degree"));
        assertTrue(EDUCATION_LEVEL.contains("Partial College"));
        assertTrue(EDUCATION_LEVEL.contains("Partial High School"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void verifyEducationLevelListIsImmutable() {
        EDUCATION_LEVEL.add("something");
    }

    @Test
    public void prompt() {
        CommandLineHelper.prompt("Question", Arrays.asList("one", "two", "three"));
        assertEquals("Question\n" +
                "1 one\n" +
                "2 two\n" +
                "3 three\n" +
                "Please enter a number: \n", outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
