package com.example.thymeleafdemo.Repositories;

import com.example.thymeleafdemo.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
}
