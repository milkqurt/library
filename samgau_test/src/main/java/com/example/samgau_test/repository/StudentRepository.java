package com.example.samgau_test.repository;

import com.example.samgau_test.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByUsername(String username);
}
