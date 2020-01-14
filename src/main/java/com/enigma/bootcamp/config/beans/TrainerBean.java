package com.enigma.bootcamp.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.enigma.bootcamp.dao.TrainerDao;
import com.enigma.bootcamp.dao.impl.TrainerDaoImpl;
import com.enigma.bootcamp.model.Trainer;
@Configuration
public class TrainerBean {

	//create dao bean
	@Bean
	public TrainerDao trainerDao() {
		return new TrainerDaoImpl();
	}

    @Bean
    @Scope("prototype")
	public Trainer trainer() {
		return new Trainer();
	}
}
