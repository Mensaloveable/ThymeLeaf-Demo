package com.example.thymeleafdemo.controllers;

import com.example.thymeleafdemo.Repositories.EmployeeRepo;
import com.example.thymeleafdemo.Repositories.ProjectRepo;
import com.example.thymeleafdemo.entities.Employee;
import com.example.thymeleafdemo.entities.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
//@RequestMapping()
public class HomeController {

    private final ProjectRepo projectRepo;
    private final EmployeeRepo employeeRepo;

    @GetMapping("/")
    public String home(Model model) {
        List<Project> projectList = projectRepo.findAll();
        List<Employee> employees = employeeRepo.findAll();
        model.addAttribute("projects", projectList);
        model.addAttribute("employees", employees);
        return "home";
    }
}
