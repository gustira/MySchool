package com.enigma.bootcamp.dao;

import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.Student;

import java.util.List;

public interface StudentDao {

    Student getById(String id);

    Student create(Student student) throws UserException;

    Student updateStudent(Student student) throws UserException;

    Student delete(Student student);

    List<Student> getStudents();
    List<Student> getStudentsByBatch(int batch_id);

    Student login(Student student) throws UserException;
}
