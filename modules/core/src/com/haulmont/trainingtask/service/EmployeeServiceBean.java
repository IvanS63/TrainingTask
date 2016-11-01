package com.haulmont.trainingtask.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.trainingtask.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service(EmployeeService.NAME)
public class EmployeeServiceBean implements EmployeeService {
    /**
     * Query to get employees with birthdays
     */
    private static final String GET_WITH_BIRTHDAYS_QUERY = "SELECT *" +
            "FROM trainingtask_employee " +
            "WHERE date_part('month',birth_date)=date_part('month',current_date)" +
            "AND date_part('day',birth_date)=date_part('day',current_date);";


    @Inject
    protected Persistence persistence;

    @Override
    @Transactional
    public List<Employee> getEmployeeWithBirthdays() {
        return persistence.getEntityManager().
                createNativeQuery(GET_WITH_BIRTHDAYS_QUERY, Employee.class).getResultList();
    }
}