package com.cooldesk.demo.services;

import com.cooldesk.demo.entity.EmployeeEntity;
import com.cooldesk.demo.model.Employee;
import com.cooldesk.demo.repositories.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        if(employee.getId() == null || employee.getId().isEmpty())
        {
            employee.setId(UUID.randomUUID().toString());
        }

        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, entity);
        employeeRepository.save(entity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {

        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();

        List<Employee> employeeList = employeeEntityList.stream().map(employeeEntity -> {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeEntity, employee);
            return employee;
        }).collect(Collectors.toList());


       return employeeList;
    }

    @Override
    public Employee getEmployeeByID(String id) {
        Employee employee = new Employee();
                BeanUtils.copyProperties(employeeRepository.findById(id).get(),employee);
                return employee;
    }

    @Override
    public String delEmployee(String id) {
        employeeRepository.deleteById(id);
        return "Employee with id "+id+" has been deleted";
    }
}
