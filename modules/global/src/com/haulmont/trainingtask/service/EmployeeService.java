package com.haulmont.trainingtask.service;


import com.haulmont.trainingtask.entity.Employee;

import java.util.List;

public interface EmployeeService {
    String NAME = "trainingtask_EmployeeService";

    /**
     * Get employees from DB with today birthdays
     *
     * @return employees with birthdays
     */
    List<Employee> getEmployeeWithBirthdays();
}