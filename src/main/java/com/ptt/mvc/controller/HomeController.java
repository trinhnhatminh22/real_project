package com.ptt.mvc.controller;

import com.ptt.mvc.model.Employee;
import com.ptt.mvc.model.Project;
import com.ptt.mvc.model.Task;
import com.ptt.mvc.service.EmployeeService;
import com.ptt.mvc.service.ProjectService;
import com.ptt.mvc.service.TaskService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        List<Project> listProject = projectService.getAllProject();
        model.addAttribute("listProject", listProject);
        return "home";
    }

    @GetMapping("/listproject/{id}")
    public String showDetailProject(@PathVariable int id, Model model) {
        Project project = projectService.getProjectById(id);
        if (project == null) {
            return "redirect:/";
        }
        model.addAttribute("project", project);
        return "detail";
    }

    @GetMapping("/editProject/{id}")
    public String showEditProject(@PathVariable int id, Model model) {
        Project project = projectService.getProjectById(id);
        if (project == null) {
            return "redirect:/";
        }
        model.addAttribute("project", project);
        return "editproject";
    }

    @PostMapping("/editProject/{id}")
    public String editProject(@PathVariable int id, @ModelAttribute("project") Project project, Model model) {
        project.setId(id);
        Project projectUpdated = projectService.updateProject(project);
        if(projectUpdated == null){
            return "redirect:/";
        }
        return "redirect:/";
    }

    @GetMapping("/createProject")
        public String showCreateProject(Model model){
            return "createproject";
        }

    @PostMapping("/createProject")
    public String createProject(@ModelAttribute("project") Project project,Model model){
        projectService.createProject(project);
        return "redirect:/";
    }

    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@ModelAttribute("id") int id, Model model){
        projectService.deleteProject(id);
        return "redirect:/";
    }

}
