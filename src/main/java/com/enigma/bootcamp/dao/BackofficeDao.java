package com.enigma.bootcamp.dao;

import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.BackOffice;


public interface BackofficeDao {
	   
    //login Trainer
    BackOffice login(BackOffice trainer) throws UserException;
}
