package com.example.thymeleafdemo.controllers;

import com.example.thymeleafdemo.Repositories.ProjectRepo;
import com.example.thymeleafdemo.entities.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectRepo projectRepo;

    @GetMapping("/new")
    public String form(Model model) {
        Project aProject = new Project();
        model.addAttribute("project", aProject);
        return "new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        projectRepo.save(project);
        //return redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }

    @GetMapping
    public String allProjects(Model model) {
        List<Project> projectList = projectRepo.findAll();
        model.addAttribute("projects", projectList);
        return "list-projects";
    }
}
