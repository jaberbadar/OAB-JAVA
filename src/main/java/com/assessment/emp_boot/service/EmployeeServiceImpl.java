package com.assessment.emp_boot.service;

import com.assessment.emp_boot.model.Employee;
import com.assessment.emp_boot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee getByEmployeeName(String empName) {
        return repository.findByName(empName)
                .orElseThrow(() -> new RuntimeException("Employee not found with name: " + empName));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        existing.setName(employee.getName());
        existing.setAge(employee.getAge());
        existing.setDepartment(employee.getDepartment());
        return repository.save(existing);
    }

    @Override
    public void deleteEmployeeByName(String empName) {
        Employee employee = repository.findByName(empName)
                .orElseThrow(() -> new RuntimeException("Employee not found with name: " + empName));
        repository.deleteByName(empName);
    }
}