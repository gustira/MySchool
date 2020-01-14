package com.enigma.bootcamp.config.beans;

import com.enigma.bootcamp.dao.StudentDao;
import com.enigma.bootcamp.dao.impl.StudentDaoImpl;
import com.enigma.bootcamp.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class StudentBean {

    @Bean
    public StudentDao studentDao(){
        return new StudentDaoImpl();
    }

    @Bean
    @Scope("prototype")
    public Student student(){
        return new Student();
    }
}
