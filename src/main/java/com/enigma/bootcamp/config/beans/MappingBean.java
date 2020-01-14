package com.enigma.bootcamp.config.beans;

import com.enigma.bootcamp.dao.MappingDao;
import com.enigma.bootcamp.dao.impl.MappingDaoImpl;
import com.enigma.bootcamp.model.MaterialMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class MappingBean {

    @Bean
    public MappingDao mappingDao(){
        return new MappingDaoImpl();
    }

    @Bean
    @Scope(scopeName = "prototype")
    public MaterialMapping mapping(){
        return new MaterialMapping();
    }

}
