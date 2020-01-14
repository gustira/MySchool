package com.enigma.bootcamp.repository;

import com.enigma.bootcamp.model.MaterialMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappingRepository extends JpaRepository<MaterialMapping, Integer> {
}
