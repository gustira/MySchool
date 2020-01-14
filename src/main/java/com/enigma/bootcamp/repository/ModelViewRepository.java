package com.enigma.bootcamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.bootcamp.model.ModelView;

public interface ModelViewRepository extends JpaRepository<ModelView, Integer>{
	
	List<ModelView> findByBatchId(int batchId);
	
}
