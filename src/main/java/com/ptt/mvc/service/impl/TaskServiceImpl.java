package com.ptt.mvc.service.impl;

import com.ptt.mvc.model.Employee;
import com.ptt.mvc.model.Project;
import com.ptt.mvc.model.Task;
import com.ptt.mvc.repository.EmployeeRepository;
import com.ptt.mvc.repository.ProjectRepository;
import com.ptt.mvc.repository.TaskRepository;
import com.ptt.mvc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Task createTask(int projectId, String name, String employeeName) {
        Employee employee = employeeRepository.findEmployeeByName(employeeName);
        Optional<Project> project = projectRepository.findById(projectId);
        if (employee == null || !project.isPresent()) {
            return null;
        }
        Task task = new Task();
        task.setEmployee(employee);
        task.setProject(project.get());
        task.setStatus(0);
        task.setNameTask(name);
        employee.getListTask().add(task);

        project.get().getListTask().add(task);
        if (!employee.getProject().contains(project.get())) {
            employee.getProject().add(project.get());
        }
        if (!project.get().getEmployees().contains(employee)) {
            project.get().getEmployees().add(employee);
            project.get().setNumber(project.get().getEmployees().size());
        }
        Task tasknew = taskRepository.save(task);
        employeeRepository.save(employee);
        projectRepository.save(project.get());
        return tasknew;
    }

    @Override
    public Task getTaskById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return task.get();
        }
        return null;
    }

    @Override
    public Task updateTask(int id, String name, String employee) {
        Optional<Task> task = taskRepository.findById(id);
        if (!task.isPresent()) {
            return null;
        }
        Project project = task.get().getProject();
        task.get().setNameTask(name);
        Employee employeeNew = employeeRepository.findEmployeeByName(employee);
        if (task.get().getEmployee() == null && employee != null) {
            task.get().setEmployee(employeeNew);
        } else if (!task.get().getEmployee().getName().equals(employee)) {
            Optional<Employee> employeeOld = employeeRepository.findById(task.get().getEmployee().getId());
            if (employeeOld.isPresent()) {
                employeeOld.get().getListTask().remove(task.get());
//                if(project.getEmployees().stre)
                employeeRepository.save(employeeOld.get());
            }
            task.get().setEmployee(employeeNew);
            employeeNew.getListTask().add(task.get());
            employeeRepository.save(employeeNew);
        }
        Task taskNew = taskRepository.save(task.get());
        if (!project.getEmployees().contains(employeeNew)) {
            employeeNew.getProject().add(project);
            project.getEmployees().add(employeeNew);
        }
        return taskNew;
    }

    @Override
    public Task updateTaskStatus(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            if (task.get().getStatus() == 1) {
                task.get().setStatus(0);
            } else {
                task.get().setStatus(1);
            }
            taskRepository.save(task.get());
            return task.get();
        }
        return null;
    }

    @Override
    public void deleteTask(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            Employee employee = task.get().getEmployee();
            if (employee != null) {
                employee.getListTask().remove(task.get());
                employeeRepository.save(employee);
            }
            Project project = task.get().getProject();
            project.getListTask().remove(task.get());
            projectRepository.save(project);
            taskRepository.delete(task.get());
        }
    }
}
