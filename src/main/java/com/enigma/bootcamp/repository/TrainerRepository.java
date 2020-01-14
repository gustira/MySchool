package com.enigma.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.bootcamp.model.Trainer;
public interface TrainerRepository extends JpaRepository<Trainer, Integer>{
	
	Trainer findByEmail(String email);
	Trainer findByUsername(String username);
}
