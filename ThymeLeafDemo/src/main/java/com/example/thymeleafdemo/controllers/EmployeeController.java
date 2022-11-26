package com.example.thymeleafdemo.controllers;

import com.example.thymeleafdemo.Repositories.EmployeeRepo;
import com.example.thymeleafdemo.entities.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepo employeeRepo;

    @GetMapping("/new")
    public String register(Model model) {
        Employee anEmployee = new Employee();
        model.addAttribute("employee", anEmployee);
        return "new-employee";
    }

    @PostMapping("/save")
    public String save(Employee employee, Model model) {
        employeeRepo.save(employee);
        return "redirect:/employees/new";
    }

    @GetMapping
    public String allEmployee(Model model) {
        List<Employee> employeeList = employeeRepo.findAll();
        model.addAttribute("employees", employeeList);
        return "list-employee";
    }
}
