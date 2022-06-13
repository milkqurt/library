package com.example.samgau_test.controllers;

import com.example.samgau_test.entity.Student;
import com.example.samgau_test.exceptions.UniversalError;
import com.example.samgau_test.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity registration(@RequestBody Student student) {
        try {
            studentService.register(student);
            return ResponseEntity.ok("Student successfully saved");
        } catch (UniversalError exist) {
            return ResponseEntity.badRequest().body(exist.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @GetMapping("/price")
    public ResponseEntity price(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(studentService.price(id));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @GetMapping("/student")
    public ResponseEntity showStudent(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(studentService.get(id));
        } catch (UniversalError notFound) {
            return ResponseEntity.badRequest().body(notFound.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(studentService.delete(id));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }
}
