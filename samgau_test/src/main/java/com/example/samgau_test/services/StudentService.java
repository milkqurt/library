package com.example.samgau_test.services;

import com.example.samgau_test.entity.Book;
import com.example.samgau_test.entity.Student;
import com.example.samgau_test.exceptions.UniversalError;
import com.example.samgau_test.models.MStudent;
import com.example.samgau_test.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student register(Student student) throws UniversalError {
        if (studentRepository.findByUsername(student.getUsername()) != null) {
            throw new UniversalError("Such a student already exists");
        }
        return studentRepository.save(student);
    }

    public MStudent get(Long id) throws UniversalError {
        Student verify = studentRepository.findById(id).get();
        if (verify == null) {
            throw new UniversalError("Student not found");
        }
        return MStudent.toModel(verify);
    }

    public Double price(Long id) {
        Student student = studentRepository.findById(id).get();
        List<Book> price = student.getBooks();
        return price.stream().mapToDouble(Book::getPrice).sum();
    }

    public Long delete(Long id) {
        studentRepository.deleteById(id);
        return id;
    }
}
