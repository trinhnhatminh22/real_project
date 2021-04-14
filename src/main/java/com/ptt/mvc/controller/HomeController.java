package com.ptt.mvc.controller;

import com.ptt.mvc.model.Project;
import com.ptt.mvc.service.EmployeeService;
import com.ptt.mvc.service.ProjectService;
import com.ptt.mvc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String showAllProject(Model model) {
        List<Project> listProject =projectService.getAllProject();
        model.addAttribute("listProject",listProject);
        return "home";
    }

    @GetMapping("/listproject/{id}")
    public String showDetailProject(@PathVariable int id, Model model) {
        Project project = projectService.getProjectById(id);
        if(project == null){
            return "home";
        }
        model.addAttribute("project",project);
        return "detail";
    }
}
