package com.ptt.mvc.service.impl;

import com.ptt.mvc.common.Mapped;
import com.ptt.mvc.model.Employee;
import com.ptt.mvc.model.Project;
import com.ptt.mvc.model.Task;
import com.ptt.mvc.repository.EmployeeRepository;
import com.ptt.mvc.repository.ProjectRepository;
import com.ptt.mvc.repository.TaskRepository;
import com.ptt.mvc.service.ProjectService;
import com.ptt.mvc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaskService taskService;

    @Override
    public List<Project> getAllProject() {
        List<Project> projectList = projectRepository.findAll();
        return projectList;
    }

    @Override
    public Project createProject(Project project) {
        Project projectCreated = projectRepository.save(project);
        return projectCreated;
    }

    @Override
    public void deleteProject(int id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            List<Task> listTask = project.get().getListTask();
            List<Employee> listEmployee = project.get().getEmployees();
            if(listEmployee.size()>0){
                for (Employee employee:listEmployee) {
                    employee.getProject().remove(project.get());
                    for (int i = 0; i < employee.getListTask().size(); i++) {
                        if(employee.getListTask().get(i).getProject().getId() == id){
                            employee.getListTask().remove(i);
                        }
                    }
                }
            }
            employeeRepository.saveAll(listEmployee);
            taskRepository.deleteAll(listTask);
            projectRepository.delete(project.get());

        }
    }

    @Override
    public Project updateProject(Project project) {
        Optional<Project> projectOptional = projectRepository.findById(project.getId());
        if (projectOptional.isPresent()) {
            project = Mapped.mappedProject(projectOptional.get(), project);
            project.setNumber(projectOptional.get().getEmployees().size());
            Project projectUpdated = projectRepository.save(project);
            return projectUpdated;
        } else {
            return null;
        }
    }

    @Override
    public Project getProjectById(int id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            return project.get();
        }
        return null;
    }

}
