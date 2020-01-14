package com.enigma.bootcamp.controller;

import java.util.List;

import com.enigma.bootcamp.dao.ValueDao;
import com.enigma.bootcamp.dto.ValueDto;
import com.enigma.bootcamp.model.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.bootcamp.dao.TrainerDao;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.helper.response.CommonResponse;
import com.enigma.bootcamp.model.Material;
import com.enigma.bootcamp.model.Trainer;

@RestController
public class TrainerController {


	private static final String BACK_TRAINER_ID = "/back-office/trainer/{id}";// declare constant routing path
	private static final String BACK_TRAINER = "/back-office/trainer";// declare constant routing path
	private static final String BACK_LIST_TRAINER = "/back-office/trainers";// declare constant routing path
	private static final String TRAINER_LOGIN = "/trainer/login"; //path login
	private static final String TRAINER_VALUE = "/trainer/value"; // path post input value

	@Autowired
	private TrainerDao trainerDao;

	@Autowired
	private ValueDao valueDao;

	//create trainer controller
	@PostMapping(path = BACK_TRAINER)
	public CommonResponse<Trainer> postTrainer(@RequestBody Trainer trainer) throws UserException {
		Trainer trn = trainerDao.save(trainer);
		CommonResponse<Trainer> response = new CommonResponse<>();
		response.setData(trn);
		return response;
	}
	
	//login trainer controller
	@PostMapping(path = TRAINER_LOGIN)
	public CommonResponse<Trainer> login(@RequestBody Trainer trainer) throws UserException {
		Trainer trn = trainerDao.login(trainer);
		CommonResponse<Trainer> response = new CommonResponse<>();
		response.setData(trn);
		return response;
	}

	// get list meterial
	@GetMapping(path = BACK_LIST_TRAINER)
	public CommonResponse<List<Trainer>> getListTrainers() {
		return new CommonResponse<>(trainerDao.getTrainers());
	}

	// get by primary
	@GetMapping(path = BACK_TRAINER_ID)
	public CommonResponse<Trainer> getByid(@PathVariable(name="id")int id) throws UserException{
		Trainer trn = trainerDao.getById(id);
		CommonResponse<Trainer> response = new CommonResponse<>();
		response.setData(trn);
		return response;
	}

	// post value
	@PostMapping(path = TRAINER_VALUE)
	public CommonResponse<Value> postValue(@RequestBody ValueDto dto) throws UserException {
		if (dto.getMaterialId().equals(null)){
			throw new UserException(40,"Material cannot empty");
		} else if (dto.getTrainerId().equals(null)){
			throw new UserException(40,"Trainer cannot empty");
		} else if (dto.getStudentId().equals(null)){
			throw new UserException(40,"Student cannot empty");
		} else {
			return new CommonResponse<>(valueDao.postValue(dto));
		}
	}
}
