package com.foodmart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @Column(name="employee_id")
    private Integer id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="position_title")
    private String positionTitle;

    @Column(name="salary")
    private Integer salary;

    @Column(name="gender")
    private String gender;

    @Column(name="birth_date")
    private Date birthDate;

    @Column(name="hire_date")
    private Date hireDate;

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }


    public static final class EmployeeBuilder {
        private Integer id;
        private String fullName;
        private String positionTitle;
        private Integer salary;
        private String gender;
        private Date birthDate;
        private Date hireDate;

        private EmployeeBuilder() {
        }

        public static EmployeeBuilder anEmployee() {
            return new EmployeeBuilder();
        }

        public EmployeeBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public EmployeeBuilder positionTitle(String positionTitle) {
            this.positionTitle = positionTitle;
            return this;
        }

        public EmployeeBuilder salary(Integer salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public EmployeeBuilder birthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public EmployeeBuilder hireDate(Date hireDate) {
            this.hireDate = hireDate;
            return this;
        }

        public Employee build() {
            Employee employee = new Employee();
            employee.positionTitle = this.positionTitle;
            employee.fullName = this.fullName;
            employee.salary = this.salary;
            employee.birthDate = this.birthDate;
            employee.hireDate = this.hireDate;
            employee.id = this.id;
            employee.gender = this.gender;
            return employee;
        }
    }
}
