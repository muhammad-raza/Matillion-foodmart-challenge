package com.foodmart;

import com.foodmart.entity.Employee;
import com.foodmart.service.FoodmartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

import static com.foodmart.commandLine.CommandLineHelper.*;

@SpringBootApplication
public class Application {

    @Autowired FoodmartService service;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        ApplicationContext context
                = new AnnotationConfigApplicationContext(Application.class);

        Application p = context.getBean(Application.class);
        p.start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);

        try {
            prompt("Department?", DEPARTMENTS);
            String department = DEPARTMENTS.get(scanner.nextInt() - 1);

            prompt("Pay type?", PAY_TYPES);
            String payType = PAY_TYPES.get(scanner.nextInt() - 1);

            prompt("Education level?", EDUCATION_LEVEL);
            String educationLevel = EDUCATION_LEVEL.get(scanner.nextInt() - 1);

            List<Employee> employees = service.getEmployees(department, payType, educationLevel);

            printTable(employees);

        } catch (Exception e){
            System.out.println("Please enter a valid number in the range provided");
        }

    }
}
