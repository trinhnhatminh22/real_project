package com.ptt.mvc.controller;

import com.ptt.mvc.model.Employee;
import com.ptt.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public String showListEmployee(Model model) {
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("list",employeeList);
        return "employee";
    }

    @GetMapping("/editEmployee/{id}")
    public String showEditEmployee(@PathVariable("id") int id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee == null) {
            return "redirect:/employee";
        }else {
            model.addAttribute("employee",employee);
            return "editemployee";
        }
    }

    @PostMapping("/editEmployee")
    public String editEmployee(@ModelAttribute("employee") Employee employee, Model model){
        Employee employeeEdit = employeeService.updateEmployee(employee);
        if(employeeEdit == null){
            return "redirect:/editEmployee/"+employee.getId();
        }
        return "redirect:/employee";
    }

    @GetMapping("/createEmployee")
    public String showCreateEmployee(Model model) {
        return "createemployee";
    }

    @PostMapping("/createEmployee")
    public String createEmployee(@ModelAttribute("employee") Employee employee, Model model){
        String message = employeeService.createEmployee(employee);
        if(message.isEmpty()){
            return "redirect:/employee";
        }else {
            model.addAttribute("message",message);
            return "createemployee";
        }
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id, Model model){
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }
}
