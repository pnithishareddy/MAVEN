package com.example.student_registration.controller;

import com.example.student_registration.exception.StudentNotFoundException;
import com.example.student_registration.model.Student;
import com.example.student_registration.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/studentsM")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    // 1. Register student
    @PostMapping
    public ResponseEntity<Student> register(@Valid @RequestBody Student student) {
        student.setStudentId(null); // ensure a new row is created
        return new ResponseEntity<>(repository.save(student), HttpStatus.CREATED);
    }

    // 2. View all students
    @GetMapping
    public List<Student> getAll() {
        return repository.findAll();
    }

    // 3. Find by ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    // 4. Delete registration
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        repository.deleteById(id);
        return ResponseEntity.ok(Map.of("message", "Registration deleted for id: " + id));
    }
}
