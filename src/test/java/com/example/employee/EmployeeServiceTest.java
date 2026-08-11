package com.example.employee;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    @Test
    void shouldReturnEmployee() {
        EmployeeService service = new EmployeeService();

        Employee employee = service.getEmployee(1L);

        assertNotNull(employee);
        assertEquals("Arun", employee.getName());
    }

    @Test
    void shouldAddEmployee() {
        EmployeeService service = new EmployeeService();

        Employee employee = service.addEmployee(
                new Employee(null, "Kumar", "Finance")
        );

        assertNotNull(employee.getId());
        assertEquals("Kumar", employee.getName());
    }
}
