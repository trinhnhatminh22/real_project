package com.ptt.mvc.service;

import com.ptt.mvc.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeByName(String name);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(int id);

    Employee updateEmployee(Employee employee);

    String createEmployee(Employee employee);

    void deleteEmployee(int id);
}
