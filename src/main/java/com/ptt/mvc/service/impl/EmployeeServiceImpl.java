package com.ptt.mvc.service.impl;

import com.ptt.mvc.model.Employee;
import com.ptt.mvc.model.Project;
import com.ptt.mvc.model.Task;
import com.ptt.mvc.repository.EmployeeRepository;
import com.ptt.mvc.repository.ProjectRepository;
import com.ptt.mvc.repository.TaskRepository;
import com.ptt.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Employee getEmployeeByName(String name) {
        Employee employee = employeeRepository.findEmployeeByName(name);
        if(employee != null){
            return employee;
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> employeeFromDB = employeeRepository.findById(employee.getId());
        if(employeeFromDB.isPresent()){
            employee.setListTask(employeeFromDB.get().getListTask());
            employee.setProject(employeeFromDB.get().getProject());
            Employee employeeAfterEdit = employeeRepository.save(employee);
            return employeeAfterEdit;
        }
        return null;
    }

    @Override
    public String createEmployee(Employee employee) {

        Employee employeeFromDB = employeeRepository.findEmployeeByName(employee.getName());
        if(employeeFromDB != null){
            return "Employee exist";
        }
        employeeRepository.save(employee);
        return "";
    }

    @Override
    public void deleteEmployee(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            Set<Project> listProject = employee.get().getProject();
            Set<Task> listTask = taskRepository.findAllByEmployeeId(id);
            for (Task task:listTask) {
                task.setEmployee(null);
            };
            for (Project project: listProject){
                project.getEmployees().remove(employee.get());
            }
            employee.get().getListTask().removeAll(listTask);
            employee.get().getProject().removeAll(listProject);
            employeeRepository.save(employee.get());
            taskRepository.saveAll(listTask);
            projectRepository.saveAll(listProject);
            employeeRepository.delete(employee.get());
        }
    }
}
