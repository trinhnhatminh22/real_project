package com.ptt.mvc.controller;

import com.ptt.mvc.model.Employee;
import com.ptt.mvc.model.Task;
import com.ptt.mvc.service.EmployeeService;
import com.ptt.mvc.service.TaskService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TaskService taskService;

    @GetMapping("/createTask/{id}")
    public String showCreateTask(@PathVariable("id") int id, Model model){
        model.addAttribute("projectId",id);
        return "createtask";
    }

    @PostMapping("/createTask")
    public String createTask(@RequestParam int projectId, String name, String employee, Model model){
        Task task = taskService.createTask(projectId,name,employee);
        if(task == null){
            model.addAttribute("projectId",projectId);
            return "createtask";
        }
        return "redirect:/";
    }

    @GetMapping("/editTask/{id}")
    public String showEditTask(@PathVariable("id") int id, Model model){
        Task task = taskService.getTaskById(id);
        if(task != null){
            model.addAttribute("task",task);
            return "edittask";
        }else {
            return "redirect:/";
        }
    }

    @PostMapping("/editTask")
    public String editTask(@RequestParam int id, String name, String employee){
        Task task = taskService.updateTask(id,name,employee);
        if(task != null){
            return "redirect:/listproject/"+task.getProject().getId();
        }else {
            return "redirect:/";
        }
    }

    @GetMapping("/editTaskStatus/{id}")
    public String editStatusTask(@PathVariable("id") int id, Model model){
        Task task = taskService.updateTaskStatus(id);
        return "redirect:/listproject/"+task.getProject().getId();
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable("id") int id, Model model){
        taskService.deleteTask(id);
        return "redirect:/";
    }
}
