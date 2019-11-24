package com.foodmart.repository;

import com.foodmart.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FoodmartRepository extends CrudRepository<Employee, Integer> {

    @Query(value = "select employee_id,full_name,e.position_title,salary,gender,birth_date,hire_Date " +
            "from employee e " +
            "INNER JOIN department d on d.department_id=e.department_id " +
            "INNER JOIN position p on p.position_id=e.position_id " +
            "where education_level=?3 " +
            "AND pay_type=?2 " +
            "AND department_description=?1",
            nativeQuery = true)
    Iterable<Employee> findByDepartmentAndPayTypeAndEducationLevel(String department, String payType, String educationLevel);
}
