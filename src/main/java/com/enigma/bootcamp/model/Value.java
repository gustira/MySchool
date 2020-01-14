package com.enigma.bootcamp.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_value")
public class Value {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_nilai")
	private int idNilai;

	@ManyToOne
	@JoinColumn(name = "id_student")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "id_materi")
	private Material material;

	@Column(name = "value")
	private Integer value;

	@ManyToOne
	@JoinColumn(name = "trainer_id")
	private Trainer trainer;

	@Column(name = "created_at", insertable=false,updatable=false)
	private Timestamp createdAt;

	@Column(name = "updated_at", insertable=false,updatable=false)
	private Timestamp updatedAt;

	public int getIdNilai() {
		return idNilai;
	}

	public void setIdNilai(int idNilai) {
		this.idNilai = idNilai;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
