package com.enigma.bootcamp.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.enigma.bootcamp.dao.BackofficeDao;
import com.enigma.bootcamp.dao.impl.BackofficeDaoImpl;
import com.enigma.bootcamp.model.BackOffice;

@Configuration
public class BackOfficeBean {

	@Bean
	public BackofficeDao backOfficeDao() {
		return new BackofficeDaoImpl();
	}
	
	@Bean
	@Scope("prototype")
	public BackOffice backOffice() {
		return new BackOffice();
	}
}
