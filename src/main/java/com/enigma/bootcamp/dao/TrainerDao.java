package com.enigma.bootcamp.dao;

import java.util.List;

import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.Material;
import com.enigma.bootcamp.model.Trainer;

public interface TrainerDao {
	
	//create trainer
	Trainer save(Trainer trainer) throws UserException;
	
    // get list trainers
    List<Trainer> getTrainers();
    
    //login Trainer
    Trainer login(Trainer trainer) throws UserException;
    
    //get primarykey
    Trainer getById(int id) throws UserException;
}
