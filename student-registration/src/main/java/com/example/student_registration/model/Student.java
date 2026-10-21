package com.example.student_registration.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "studentsM")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_gen")
	@SequenceGenerator(name = "student_gen", sequenceName = "student_seq", allocationSize = 1)
	private Long studentId;

    @NotBlank(message = "Student name cannot be empty")
    @Column(nullable = false)
    private String studentName;

    @NotBlank(message = "Course name cannot be empty")
    @Column(nullable = false)
    private String courseName;

    @Email(message = "Enter valid email")
    @NotBlank(message = "Email cannot be empty")
    @Column(nullable = false)
    private String email;

    @Min(value = 18, message = "Age must be above 18")
    private int age;

    public Student() {}

    public Student(Long studentId, String studentName, String courseName, String email, int age) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseName = courseName;
        this.email = email;
        this.age = age;
    }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
