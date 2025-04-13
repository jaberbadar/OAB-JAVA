package com.assessment.emp_boot.controller;

import com.assessment.emp_boot.model.Employee;
import com.assessment.emp_boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee saved = service.addEmployee(employee);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<Employee> getEmployee(@RequestParam("empName") String empName) {
        try {
            Employee employee = service.getByEmployeeName(empName);
            return ResponseEntity.ok(employee);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
        try {
            Employee updated = service.updateEmployee(employee, id);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{empName}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String empName) {
        try {
            service.deleteEmployeeByName(empName);
            return ResponseEntity.ok("Deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }
}