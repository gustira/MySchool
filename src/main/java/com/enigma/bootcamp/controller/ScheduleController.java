package com.enigma.bootcamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.bootcamp.dao.ScheduleDao;
import com.enigma.bootcamp.dto.MaterialDto;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.helper.response.CommonResponse;
import com.enigma.bootcamp.model.ModelView;
import com.enigma.bootcamp.model.Schedule;
import com.enigma.bootcamp.model.Student;
import com.enigma.bootcamp.model.Trainer;

@RestController
public class ScheduleController {

	public static final String URI_REQUEST_SCHEDULE = "schedule";
	public static final String URI_REQUEST_SCHEDULES = "schedules";
	public static final String URI_REQUEST_BATCH_ID_SCHEDULES = "schedule/{id}/batchs";

	@Autowired
	private ScheduleDao scheduleDao;

	@PostMapping(value = URI_REQUEST_SCHEDULE)
	public CommonResponse<Schedule> createSchedule(@RequestBody Schedule schedule) {
		CommonResponse<Schedule> data = new CommonResponse<>();
		Schedule std = scheduleDao.createSchedule(schedule);
		data.setData(std);
		return data;
	}

	// get list meterial
	@GetMapping(path = URI_REQUEST_SCHEDULES)
	public CommonResponse<List<Schedule>> getListSchedule() {
		return new CommonResponse<>(scheduleDao.getList());
	}
	
	@GetMapping(path = URI_REQUEST_BATCH_ID_SCHEDULES)
	 public CommonResponse<List<ModelView>> getBatch(@PathVariable(name = "id") int id) throws UserException {
		List<ModelView> view = scheduleDao.getByBatch(id);
		CommonResponse<List<ModelView>> response = new CommonResponse<>();
		response.setData(view);
		return response;
	    }
	
}
