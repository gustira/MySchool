package com.enigma.bootcamp.repository;

import com.enigma.bootcamp.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepository extends JpaRepository<Batch, Integer> {
}
