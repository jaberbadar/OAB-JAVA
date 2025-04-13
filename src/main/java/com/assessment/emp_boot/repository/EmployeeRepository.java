package com.assessment.emp_boot.repository;

import com.assessment.emp_boot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByName(String name);
    void deleteByName(String name);
}