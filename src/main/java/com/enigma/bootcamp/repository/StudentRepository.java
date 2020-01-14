package com.enigma.bootcamp.repository;

import com.enigma.bootcamp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByEmail(String email);
    Student findByUsername(String username);
    Student findTopByOrderByIdDesc();
}
