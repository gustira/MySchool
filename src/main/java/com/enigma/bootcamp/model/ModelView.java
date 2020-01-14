package com.enigma.bootcamp.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="v_schedule")
public class ModelView {

	@Id
	@Column(name = "schedule_id")
	private int scheduleId;
	private Date date;
	private Date start;
	private Date finish;
	@Column(name = "mapping_id")
	private int mappingId;
	@Column(name = "id")
	private int trainerId;
	@Column(name = "batch_id")
	private int batchId;
	@Column(name = "id_materi")
	private int idMateri;
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getFinish() {
		return finish;
	}
	public void setFinish(Date finish) {
		this.finish = finish;
	}
	public int getMappingId() {
		return mappingId;
	}
	public void setMappingId(int mappingId) {
		this.mappingId = mappingId;
	}
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public int getIdMateri() {
		return idMateri;
	}
	public void setIdMateri(int idMateri) {
		this.idMateri = idMateri;
	}
	
	
}
