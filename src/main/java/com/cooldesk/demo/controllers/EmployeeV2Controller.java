package com.cooldesk.demo.controllers;

import com.cooldesk.demo.model.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {

    @PostMapping("/save-employee")
    public Employee saveEmp(@RequestBody Employee employee){
        return employee;
    }
}
