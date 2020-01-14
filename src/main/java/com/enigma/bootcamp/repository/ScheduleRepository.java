package com.enigma.bootcamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.enigma.bootcamp.model.MaterialMapping;
import com.enigma.bootcamp.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{

}
