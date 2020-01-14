package com.enigma.bootcamp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.enigma.bootcamp.dao.MappingDao;
import com.enigma.bootcamp.dao.ScheduleDao;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.Batch;
import com.enigma.bootcamp.model.MaterialMapping;
import com.enigma.bootcamp.model.ModelView;
import com.enigma.bootcamp.model.Schedule;
import com.enigma.bootcamp.repository.ModelViewRepository;
import com.enigma.bootcamp.repository.ScheduleRepository;
import com.enigma.bootcamp.repository.TrainerRepository;

public class ScheduleDaoImpl implements ScheduleDao {
	 
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ScheduleRepository repository;
	
	@Autowired
	private ModelViewRepository repositoryView;

	@Autowired
	private BatchDaoImpl batchDaoImpl;
	
	@Autowired
	private MappingDao mappingDao;
	
	// create schedule
	@Override
	@Transactional
	public Schedule createSchedule(Schedule schedule) {
		Schedule schdl = em.merge(schedule);
		return schdl;
	}

	@Override
	public List<Schedule> getList() {
		Query query = em.createQuery("From Schedule");
		return query.getResultList();
	}

	@Override
	public List<ModelView> getByBatch(int batch) throws UserException {

		if (repositoryView.findByBatchId(batch)!=null) {
			return repositoryView.findByBatchId(batch);
		}else{
			 throw new UserException(44, "NotFound");
		}
		
		
	}

}
