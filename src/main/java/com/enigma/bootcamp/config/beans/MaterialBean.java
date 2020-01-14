package com.enigma.bootcamp.config.beans;

import com.enigma.bootcamp.dao.MaterialDao;
import com.enigma.bootcamp.dao.impl.MaterialDaoImpl;
import com.enigma.bootcamp.model.Material;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class MaterialBean {

    // dao bean
    @Bean
    public MaterialDao materialDao(){
        return new MaterialDaoImpl();
    }

    @Bean
    @Scope(scopeName = "prototype")
    public Material material(){
        return new Material();
    }
}
