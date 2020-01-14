package com.enigma.bootcamp.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.enigma.bootcamp.model.ModelView;


@Configuration
public class modelViewBean {

	@Bean
	@Scope("prototype")
	public ModelView modelView() {
		return new ModelView();
	}
}
