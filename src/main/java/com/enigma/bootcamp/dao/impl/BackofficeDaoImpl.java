package com.enigma.bootcamp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.enigma.bootcamp.dao.BackofficeDao;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.BackOffice;
import com.enigma.bootcamp.model.Trainer;
import com.enigma.bootcamp.repository.BackOfficeRepository;

public class BackofficeDaoImpl implements BackofficeDao {

	@Autowired
	private BackOfficeRepository repository;
	
	@Override
	public BackOffice login(BackOffice trainer) throws UserException {
		if (repository.findByUsername(trainer.getUsername()) != null) {
			BackOffice username = repository.findByUsername(trainer.getUsername());
			if (trainer.getPassword().equals(username.getPassword())) {
				return username;
			} else {
				throw new UserException(44, "Wrong Email Or Password!");
			}
		} else {
			throw new UserException(44, "Wrong Email Or Password!");
		}
	}
}
