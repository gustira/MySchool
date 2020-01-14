package com.enigma.bootcamp.config.beans;

import com.enigma.bootcamp.dao.ValueDao;
import com.enigma.bootcamp.dao.impl.ValueDaoImpl;
import com.enigma.bootcamp.model.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class ValueBean {

    @Bean
    public ValueDao valueDao(){
        return new ValueDaoImpl();
    }

    @Bean
    @Scope(scopeName = "prototype")
    public Value value(){
        return new Value();
    }
}
