package com.assessment.emp_boot.service;

import com.assessment.emp_boot.model.Employee;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee getByEmployeeName(String empName);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployeeByName(String empName);
}