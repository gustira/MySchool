package com.enigma.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.bootcamp.model.BackOffice;

public interface BackOfficeRepository extends JpaRepository<BackOffice, Integer>{
	
	BackOffice findByUsername(String username);

}
