package com.cooldesk.demo.services;

import com.cooldesk.demo.error.EmployeeNotFoundException;
import com.cooldesk.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class EmployeeServiceImp implements EmployeeService {

    List<Employee> employeesList = new ArrayList<>();

    @Override
    public Employee saveEmployee(Employee employee) {
        if(employee.getId() == null || employee.getId().isEmpty())
        {
            employee.setId(UUID.randomUUID().toString());
        }
        employeesList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeesList;
    }

    @Override
    public Employee getEmployeeByID(String id) {
       return employeesList.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElseThrow(() -> new EmployeeNotFoundException(""+"Employee Not Found with Id: "+id));
    }

    @Override
    public String delEmployee(String id) {

        Employee employee = employeesList.stream().filter(emp -> emp.getId().equalsIgnoreCase(id)).findFirst().get();

        employeesList.remove(employee);
        return "Employee with id "+id+" has been deleted";
    }
}
