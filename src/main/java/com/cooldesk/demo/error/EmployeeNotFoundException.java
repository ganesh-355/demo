package com.cooldesk.demo.error;

import com.cooldesk.demo.model.Employee;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String message){
        super(message);
    }
}
