package com.enigma.bootcamp.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.enigma.bootcamp.dao.ScheduleDao;
import com.enigma.bootcamp.dao.impl.ScheduleDaoImpl;
import com.enigma.bootcamp.model.Schedule;

@Configuration
public class ScheduleBean {

	@Bean
	public ScheduleDao scheduleDao() {
		return new ScheduleDaoImpl();
	}
	
	@Bean
	@Scope("prototype")
	public Schedule schedule() {
		return new Schedule();
	}
}
