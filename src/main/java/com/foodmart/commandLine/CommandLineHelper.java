package com.foodmart.commandLine;

import com.foodmart.converter.DateConverter;
import com.foodmart.converter.SalaryConverter;
import com.foodmart.entity.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hard coding command line data due to time constraint.
 * Would be good to get this list from database, so we can
 * access updated list and dont have to add data manually.
 */

public class CommandLineHelper {

    //unmodifiable lists
    public static final List<String> DEPARTMENTS;
    public static final List<String> PAY_TYPES;
    public static final List<String> EDUCATION_LEVEL;

    private static final List<String> DEPARTMENTS_LIST = new ArrayList<>();
    private static final List<String> PAY_TYPES_LIST = new ArrayList<>();
    private static final List<String> EDUCATION_LEVEL_LIST = new ArrayList<>();
    static {
        DEPARTMENTS_LIST.add("HQ General Management");
        DEPARTMENTS_LIST.add("HQ Information Systems");
        DEPARTMENTS_LIST.add("HQ Marketing");
        DEPARTMENTS_LIST.add("HQ Human Resources");
        DEPARTMENTS_LIST.add("HQ Finance and Accounting");
        DEPARTMENTS_LIST.add("Store Management");
        DEPARTMENTS_LIST.add("Store Information Systems");
        DEPARTMENTS_LIST.add("Permanent Checkers");
        DEPARTMENTS_LIST.add("Temp Checkers");
        DEPARTMENTS_LIST.add("Permanent Stockers");
        DEPARTMENTS_LIST.add("Temp Stockers");
        DEPARTMENTS_LIST.add("Store Permanent Butchers");

        PAY_TYPES_LIST.add("Monthly");
        PAY_TYPES_LIST.add("Hourly");
        EDUCATION_LEVEL_LIST.add("Bachelors Degree");
        EDUCATION_LEVEL_LIST.add("Graduate Degree");
        EDUCATION_LEVEL_LIST.add("High School Degree");
        EDUCATION_LEVEL_LIST.add("Partial College");
        EDUCATION_LEVEL_LIST.add("Partial High School");


        DEPARTMENTS = Collections.unmodifiableList(DEPARTMENTS_LIST);
        PAY_TYPES = Collections.unmodifiableList(PAY_TYPES_LIST);
        EDUCATION_LEVEL = Collections.unmodifiableList(EDUCATION_LEVEL_LIST);
    }

    private static final String[] HEADERS = {"ID", "Name", "Postition", "Salary", "Gender", "DOB", "Hired on" };

    public static void prompt(String question, List<String> options) {
        System.out.println(question);
        //not using java 8 stream because index is needed here
        for (int i=0; i<options.size(); i++) {
            System.out.println(String.format("%s %s", i+1, options.get(i)));
        }
        System.out.println("Please enter a number: ");
    }

    public static void printTable(List<Employee> employees) {
        CommandLineTable commandLineTable = new CommandLineTable();
        commandLineTable.setHeaders(HEADERS);
        SalaryConverter salaryConverter = new SalaryConverter();
        DateConverter dateConverter = new DateConverter();
        employees.forEach(e -> {
            commandLineTable.addRow(
                    e.getId(),
                    e.getFullName(),
                    e.getPositionTitle(),
                    salaryConverter.convert(e.getSalary()),
                    e.getGender(),
                    dateConverter.convert(e.getBirthDate()),
                    dateConverter.convert(e.getHireDate()));
        });

        commandLineTable.print();
    }
}
