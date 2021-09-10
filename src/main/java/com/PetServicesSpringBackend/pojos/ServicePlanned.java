package com.PetServicesSpringBackend.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the service_planned database table.
 * 
 */
@Entity
@Table(name="service_planned")
@NamedQuery(name="ServicePlanned.findAll", query="SELECT s FROM ServicePlanned s")
public class ServicePlanned implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="cost_per_unit")
	private BigDecimal costPerUnit;

	@Lob
	private String notes;

	@Column(name="planned_end_time")
	private Timestamp plannedEndTime;

	@Column(name="planned_price")
	private BigDecimal plannedPrice;

	@Column(name="planned_start_time")
	private Timestamp plannedStartTime;

	@Column(name="planned_units")
	private int plannedUnits;

	//bi-directional many-to-one association to Cas
	@ManyToOne
	@JoinColumn(name="case_id")
	private Cas cas;

	//bi-directional many-to-one association to Service
	@ManyToOne
	private Service service;

	public ServicePlanned() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getCostPerUnit() {
		return this.costPerUnit;
	}

	public void setCostPerUnit(BigDecimal costPerUnit) {
		this.costPerUnit = costPerUnit;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Timestamp getPlannedEndTime() {
		return this.plannedEndTime;
	}

	public void setPlannedEndTime(Timestamp plannedEndTime) {
		this.plannedEndTime = plannedEndTime;
	}

	public BigDecimal getPlannedPrice() {
		return this.plannedPrice;
	}

	public void setPlannedPrice(BigDecimal plannedPrice) {
		this.plannedPrice = plannedPrice;
	}

	public Timestamp getPlannedStartTime() {
		return this.plannedStartTime;
	}

	public void setPlannedStartTime(Timestamp plannedStartTime) {
		this.plannedStartTime = plannedStartTime;
	}

	public int getPlannedUnits() {
		return this.plannedUnits;
	}

	public void setPlannedUnits(int plannedUnits) {
		this.plannedUnits = plannedUnits;
	}

	public Cas getCas() {
		return this.cas;
	}

	public void setCas(Cas cas) {
		this.cas = cas;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

}