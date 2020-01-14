package com.enigma.bootcamp.controller;

import com.enigma.bootcamp.dao.StudentDao;
import com.enigma.bootcamp.exception.EntityNotFoundException;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.helper.response.CommonResponse;
import com.enigma.bootcamp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    public static final String URI_REQUEST_STUDENT = "student";
    private static final String URI_REQUEST_STUDENT_BY_ID = "student/{id}";
    private static final String URI_REQUEST_STUDENT_LOGIN = "student/login";
    private static final String URI_REQUEST_STUDENTS = "students";
    private static final  String URI_REQUEST_STUDENTS_BY_BATCH = "students/{batch_id}";

    @Autowired
    private StudentDao studentmDao;


    @GetMapping(value = URI_REQUEST_STUDENTS, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse<List<Student>> getStudents() throws EntityNotFoundException {
        List<Student> students = studentmDao.getStudents();
        CommonResponse<List<Student>> response = new CommonResponse<>();
        if (!students.isEmpty()) {
            response.setData(students);
        } else {
            throw new EntityNotFoundException(44, "Students doesn't exist!");
        }
        return response;
    }

    @GetMapping(value = URI_REQUEST_STUDENTS_BY_BATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse<List<Student>> getStudentsByBatchId(@PathVariable(name = "batch_id") int batch_id) throws EntityNotFoundException {
        List<Student> students = studentmDao.getStudentsByBatch(batch_id);
        CommonResponse<List<Student>> response = new CommonResponse<>();
        if (!students.isEmpty()) {
            response.setData(students);
        } else {
            throw new EntityNotFoundException(44, "Students doesn't exist!");
        }
        return response;
    }

    @GetMapping(value = URI_REQUEST_STUDENT_BY_ID)
    public CommonResponse<Student> getStudentById(@PathVariable(name = "id") String id) throws EntityNotFoundException {
        Student student = studentmDao.getById(id);
        CommonResponse<Student> response = new CommonResponse<>();
        if (student == null) {
            throw new EntityNotFoundException(44, String.format("Student ID %d not found", id));
        } else {
            response.setData(student);
        }
        return response;
    }

    @PostMapping(value = URI_REQUEST_STUDENT)
    public CommonResponse<Student> createStudent(@RequestBody Student student) throws UserException {
        CommonResponse<Student> data = new CommonResponse<>();
        Student std = studentmDao.create(student);
        data.setData(std);
        return data;
    }

    @PutMapping(value = URI_REQUEST_STUDENT)
    public CommonResponse<Student> updateStudent(@RequestBody Student student) throws EntityNotFoundException, UserException {
        Student data = studentmDao.getById(student.getId());
        CommonResponse<Student> response = new CommonResponse<>();
        if (data == null) {
            throw new EntityNotFoundException(44, "Student data doesn't exist!");
        } else {
            studentmDao.updateStudent(student);
            response.setData(student);
        }
        return response;
    }

    @DeleteMapping(value = URI_REQUEST_STUDENT_BY_ID)
    public CommonResponse<Student> deleteStudent(@PathVariable(name = "id") String id) throws EntityNotFoundException {
        Student student = studentmDao.getById(id);
        CommonResponse<Student> response = new CommonResponse<>();
        if (student == null) {
            throw new EntityNotFoundException(44, String.format("Student ID %d not found", id));
        } else {
            response.setData(studentmDao.delete(student));
        }
        return response;
    }

    @PostMapping(path = URI_REQUEST_STUDENT_LOGIN)
    public CommonResponse<Student> login(@RequestBody Student student) throws UserException {
        Student std = studentmDao.login(student);
        CommonResponse<Student> response = new CommonResponse<>();
        response.setData(std);
        return response;
    }
}
