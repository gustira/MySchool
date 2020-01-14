package com.enigma.bootcamp.repository;

import com.enigma.bootcamp.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
