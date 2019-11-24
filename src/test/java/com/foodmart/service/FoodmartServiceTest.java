package com.foodmart.service;

import com.foodmart.entity.Employee;
import com.foodmart.repository.FoodmartRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.foodmart.entity.Employee.EmployeeBuilder.anEmployee;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class FoodmartServiceTest {
    private FoodmartService foodmartService;

    @MockBean
    private FoodmartRepository foodmartRepository;

    private static final String DEPARTMENT = "Store Management";
    private static final String PAY_TYPE = "Monthly";
    private static final String EDUCATION_LEVEL = "Bachelors Degree";

    @Before
    public void setUp() throws Exception {
        List<Employee> employees = new ArrayList<>();
        employees.add(
                anEmployee()
                        .id(1)
                        .fullName("Michael Everson")
                        .positionTitle("Store Permanent Checker")
                        .gender("M")
                        .salary(54000)
                        .birthDate(new Date(1574628046989L))
                        .hireDate(new Date(1574628046989L))
                        .build());
        when(foodmartRepository.findByDepartmentAndPayTypeAndEducationLevel(DEPARTMENT, PAY_TYPE, EDUCATION_LEVEL)).thenReturn(employees);
        foodmartService = new FoodmartService(foodmartRepository);
    }


    @Test
    public void shouldReturnListOfEmployees() {
        List<Employee> employees = foodmartService.getEmployees(DEPARTMENT, PAY_TYPE, EDUCATION_LEVEL);

        verify(foodmartRepository, only()).findByDepartmentAndPayTypeAndEducationLevel(DEPARTMENT, PAY_TYPE, EDUCATION_LEVEL);

        assertEquals(1, employees.size());

        Employee anEmployee = employees.get(0);
        assertEquals(1, (int) anEmployee.getId());
        assertEquals("Michael Everson", anEmployee.getFullName());
        assertEquals("Store Permanent Checker", anEmployee.getPositionTitle());
        assertEquals("M", anEmployee.getGender());
        assertEquals(54000, (int) anEmployee.getSalary());
        assertEquals(new Date(1574628046989L), anEmployee.getBirthDate());
        assertEquals(new Date(1574628046989L), anEmployee.getHireDate());


    }
}
