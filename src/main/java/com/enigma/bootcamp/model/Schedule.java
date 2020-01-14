package com.enigma.bootcamp.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id")
    private int scheduleId;
    @ManyToOne
    @JoinColumn(name = "id")
    private Trainer trainer;
    @ManyToOne
    @JoinColumn(name = "mapping_id")
    private MaterialMapping materialMapping;
    private Date date;
    private Time start;
    private Time finish;
	@Column(name="created_at", insertable=false,updatable=false)
    private Timestamp createdAt;
	@Column(name = "updated_at", insertable=false,updatable=false)
    private Timestamp updatedAt;

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public MaterialMapping getMaterialMapping() {
        return materialMapping;
    }

    public void setMaterialMapping(MaterialMapping materialMapping) {
        this.materialMapping = materialMapping;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStart() {
		return start;
	}

	public void setStart(Time start) {
		this.start = start;
	}

	public Time getFinish() {
		return finish;
	}

	public void setFinish(Time finish) {
		this.finish = finish;
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
