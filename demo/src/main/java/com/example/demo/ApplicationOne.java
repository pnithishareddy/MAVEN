
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationOne {

    private final Department department;

    @Autowired
    public ApplicationOne(Department department) {
        this.department = department;
    }

    public void display() {
        System.out.println("Application One");
        department.displayDepartments();
    }
}
