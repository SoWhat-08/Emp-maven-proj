package com.example.employee.service;

import com.example.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new Employee(1L, "Arun", "IT"));
        employees.add(new Employee(2L, "Priya", "HR"));
    }

    public List<Employee> getAllEmployees() {
        return employees; //Developer A
    }

    public Employee getEmployee(Long id) {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        employee.setId((long) (employees.size() + 1));
        employees.add(employee);
        return employee;
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existing = getEmployee(id);

        if (existing == null) {
            return null;
        }

        existing.setName(updatedEmployee.getName());
        existing.setDepartment(updatedEmployee.getDepartment());
        return existing;
    }

    public boolean deleteEmployee(Long id) {
        return employees.removeIf(employee -> employee.getId().equals(id));
    }

    // Developer B modification
    public List<Employee> searchEmployeesByDepartment(String department) {
        return employees.stream()
                .filter(employee ->
                        employee.getDepartment().equalsIgnoreCase(department))
                .toList();
    }
}