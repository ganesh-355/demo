package com.cooldesk.demo.services;

import com.cooldesk.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeByID(String id);
}
