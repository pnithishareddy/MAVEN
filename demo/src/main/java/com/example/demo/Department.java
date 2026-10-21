
package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Department {

    @Value("#{ {'HR', 'DEV', 'Testing', 'Finance', 'Sales'} }")
    private List<String> departments;

    public List<String> getDepartments() {
        return departments;
    }

    public void displayDepartments() {
        System.out.println("Departments: " + departments);
    }
}

