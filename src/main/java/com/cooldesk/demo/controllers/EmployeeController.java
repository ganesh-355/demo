package com.cooldesk.demo.controllers;

import com.cooldesk.demo.model.Employee;
import com.cooldesk.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save-employee")
    public Employee saveEmp(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping()
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable String id)
    {
        return employeeService.getEmployeeByID(id);
    }

    @DeleteMapping("/{id}")
    public String delEmployee(@PathVariable String id)
    {
        return employeeService.delEmployee(id);
    }
}
