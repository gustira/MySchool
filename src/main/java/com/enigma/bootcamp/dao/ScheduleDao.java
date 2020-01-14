package com.enigma.bootcamp.dao;

import java.util.List;

import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.MaterialMapping;
import com.enigma.bootcamp.model.ModelView;
import com.enigma.bootcamp.model.Schedule;

public interface ScheduleDao {

    Schedule createSchedule(Schedule schedule);
    List<Schedule> getList();
//    List<ModelView> getByBatch(int batch) throws UserException;
	List<ModelView> getByBatch(int batch) throws UserException;

}
