package com.enigma.bootcamp.repository;

import com.enigma.bootcamp.model.Value;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueRepository extends JpaRepository<Value, Integer> {
}
