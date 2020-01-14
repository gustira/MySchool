package com.enigma.bootcamp.dao.impl;

import com.enigma.bootcamp.util.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import com.enigma.bootcamp.dao.StudentDao;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.Student;
import com.enigma.bootcamp.repository.StudentRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    @Override
    public Student getById(String id) {
        return entityManager.find(Student.class, id);
    }

    @Transactional
    @Override
    public Student create(Student student) throws UserException {
        String name = student.getName().charAt(0) + "";
        Student lastId = studentRepository.findTopByOrderByIdDesc();
        String lastNum;
        if (lastId == null) {lastNum = "00000"; }
        else {lastNum = lastId.getId().substring(1);}
        String newId = GenerateId.getNum(lastNum, name);

        if (student != null) {
            if (studentRepository.findByEmail(student.getEmail()) != null) {
                throw new UserException(49, "Email lu udah terdaftar ANJING!!!");
            }
            else if (studentRepository.findByUsername(student.getUsername()) != null) {
                throw new UserException(49, "Username lu udah terdaftar ANJING!!!");
            }
            else {
//                customer.setCif(newCif);
//                Customer cust =  repository.save(customer);
//                account.setCustomer(cust);
//                accountDao.save(account);
//                return cust;
                student.setId(newId);
                Student data = entityManager.merge(student);
                return data;
            }

        }throw new UserException(43, "data is null");


    }

    @Transactional
    @Override
    public Student updateStudent(Student student) throws UserException {

        if (student != null) {
            if (studentRepository.findByEmail(student.getEmail()) != null) {
                throw new UserException(49, "Email lu udah terdaftar ANJING!!!");
            }
            else if (studentRepository.findByUsername(student.getUsername()) != null) {
                throw new UserException(49, "Username lu udah terdaftar ANJING!!!");
            }
            else {
                Student data = entityManager.merge(student);
                return data;
            }
        }throw new UserException(43, "Tidak ada data yang diupdete");

    }

    @Transactional
    @Override
    public Student delete(Student student) {
        entityManager.remove(student);
        return student;
    }

    @Transactional
    @Override
    public List<Student> getStudents() {
        Query query = entityManager.createQuery("From Student");
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Student> getStudentsByBatch(int batch_id) {
        //using query builder
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);

        query.select(root).where(builder.equal(root.get("batch").get("batchId"), batch_id));

        Query qry = entityManager.createQuery(query);

        return qry.getResultList();
    }

    @Override
    public Student login(Student student) throws UserException {
        if (studentRepository.findByUsername(student.getUsername()) != null) {
            Student username = studentRepository.findByUsername(student.getUsername());
            if (student.getPassword().equals(username.getPassword())) {
                return username;
            } else {
                throw new UserException(44, "Wrong Email Or Password!");
            }
        } else {
            throw new UserException(44, "Wrong Email Or Password!");
        }
    }
}