package com.ptt.mvc.repository;

import com.ptt.mvc.model.Employee;
import com.ptt.mvc.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findEmployeeByName(String name);

    List<Employee> findEmployeeByProject(Project project);

}
