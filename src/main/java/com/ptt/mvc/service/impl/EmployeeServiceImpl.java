package com.ptt.mvc.service.impl;

import com.ptt.mvc.model.Employee;
import com.ptt.mvc.repository.EmployeeRepository;
import com.ptt.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Override
//    public List<Employee> getAllEmployee() {
//        return employeeRepository.findAll();
//    }
//
//    @Override
//    public Employee createEmployee(Employee employee) {
//        Employee employeeInsert =  employeeRepository.save(employee);
//        return employeeInsert;
//    }
//
//    @Override
//    public Employee updateEmployee(Employee employee) {
//        Employee employeeReturn = employeeRepository.save(employee);
//        return employeeReturn;
//    }


}
