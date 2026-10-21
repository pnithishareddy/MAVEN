
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationTwo {

    private final Department department;

    @Autowired
    public ApplicationTwo(Department department) {
        this.department = department;
    }

    public void display() {
        System.out.println("Application Two");
        department.displayDepartments();
    }
}
