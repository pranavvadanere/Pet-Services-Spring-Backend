package com.PetServicesSpringBackend.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the current_status database table.
 * 
 */
@Entity
@Table(name="current_status")
@NamedQuery(name="CurrentStatus.findAll", query="SELECT c FROM CurrentStatus c")
public class CurrentStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="insert_time")
	private Timestamp insertTime;

	@Lob
	private String notes;

	//bi-directional many-to-one association to Cas
	@ManyToOne
	@JoinColumn(name="case_id")
	private Cas cas;

	//bi-directional many-to-one association to Status
	@ManyToOne
	private Status status;

	public CurrentStatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getInsertTime() {
		return this.insertTime;
	}

	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Cas getCas() {
		return this.cas;
	}

	public void setCas(Cas cas) {
		this.cas = cas;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}