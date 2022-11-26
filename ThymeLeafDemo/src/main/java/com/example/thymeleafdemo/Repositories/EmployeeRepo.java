package com.example.thymeleafdemo.Repositories;

import com.example.thymeleafdemo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
