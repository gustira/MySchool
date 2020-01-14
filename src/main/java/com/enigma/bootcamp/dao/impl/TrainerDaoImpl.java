package com.enigma.bootcamp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.enigma.bootcamp.dao.TrainerDao;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.Material;
import com.enigma.bootcamp.model.Trainer;
import com.enigma.bootcamp.repository.MaterialRepository;
import com.enigma.bootcamp.repository.TrainerRepository;

public class TrainerDaoImpl implements TrainerDao {

	@PersistenceContext
	private EntityManager em;

	// inject treiner repository
	@Autowired
	private TrainerRepository repository;

	@Override
	@Transactional
	public Trainer save(Trainer trainer) throws UserException {
		if (trainer != null) {
			if (repository.findByEmail(trainer.getEmail()) != null) {
				throw new UserException(49, "Email is exist!");
			} else if (repository.findByUsername(trainer.getUsername()) != null) {
				throw new UserException(49, "Username is exist!");
			} else {
				Trainer save = em.merge(trainer);
				return save;
			}
		} else {
			return null;
		}

	}

	@Override
	public List<Trainer> getTrainers() {
		List<Trainer> trainers = repository.findAll();
		if (trainers.isEmpty())
			return null;
		else
			return trainers;
	}

	@Override
	public Trainer login(Trainer trainer) throws UserException {
		if (repository.findByUsername(trainer.getUsername()) != null) {
			Trainer username = repository.findByUsername(trainer.getUsername());
			if (trainer.getPassword().equals(username.getPassword())) {
				return username;
			} else {
				throw new UserException(44, "Wrong Email Or Password!");
			}
		} else {
			throw new UserException(44, "Wrong Email Or Password!");
		}

	}

	@Override
	public Trainer getById(int id) throws UserException {
		if (em.find(Trainer.class, id) != null) {
			return em.find(Trainer.class, id);
		}
		throw new  UserException(44, "Entity Not found");
	}
}
