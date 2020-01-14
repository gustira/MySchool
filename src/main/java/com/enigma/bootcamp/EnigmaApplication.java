package com.enigma.bootcamp;

import com.enigma.bootcamp.config.beans.BatchBean;
import com.enigma.bootcamp.config.beans.MappingBean;
import com.enigma.bootcamp.config.beans.MaterialBean;
import com.enigma.bootcamp.config.beans.StudentBean;
import com.enigma.bootcamp.model.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.enigma.bootcamp.model"})
@EnableJpaRepositories({"com.enigma.bootcamp.repository"})
@Import({MaterialBean.class, StudentBean.class, Value.class, MappingBean.class})
public class EnigmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnigmaApplication.class, args);
	}

}
