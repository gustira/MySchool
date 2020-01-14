package com.enigma.bootcamp.config.beans;

import com.enigma.bootcamp.dao.BatchDao;
import com.enigma.bootcamp.dao.impl.BatchDaoImpl;
import com.enigma.bootcamp.model.Batch;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class BatchBean {

    @Bean
    public BatchDao batchDao(){
        return new BatchDaoImpl();
    }

    @Bean
    @Scope("prototype")
    public Batch batch(){
        return new Batch();
    }

}
