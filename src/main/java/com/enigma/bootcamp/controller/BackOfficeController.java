package com.enigma.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.bootcamp.dao.BackofficeDao;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.helper.response.CommonResponse;
import com.enigma.bootcamp.model.BackOffice;
import com.enigma.bootcamp.model.Trainer;

@RestController
public class BackOfficeController {
	
	private static final String BACK_OFFICE_LOGIN = "/back-office/login"; //path login

	@Autowired
	private BackofficeDao backOfficeDao;
	//login backoffice controller
		@PostMapping(path = BACK_OFFICE_LOGIN)
		public CommonResponse<BackOffice> login(@RequestBody BackOffice backOffice) throws UserException {
			BackOffice trn = backOfficeDao.login(backOffice);
			CommonResponse<BackOffice> response = new CommonResponse<>();
			response.setData(trn);
			return response;
		}
}
