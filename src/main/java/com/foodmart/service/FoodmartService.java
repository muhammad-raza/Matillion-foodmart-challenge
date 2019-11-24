package com.foodmart.service;

import com.foodmart.entity.Employee;
import com.foodmart.repository.FoodmartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodmartService {

    private final FoodmartRepository foodmartRepository;

    @Autowired
    public FoodmartService(FoodmartRepository foodmartRepository) {
        this.foodmartRepository = foodmartRepository;
    }

    public List<Employee> getEmployees(String department, String payType, String education){
        List<Employee> result = new ArrayList<>();
        Iterable<Employee> employeeIterable = foodmartRepository.findByDepartmentAndPayTypeAndEducationLevel(department, payType, education);
        employeeIterable.forEach(result::add);
        return result;
    }
}
