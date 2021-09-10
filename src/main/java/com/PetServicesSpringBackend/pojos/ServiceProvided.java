package com.PetServicesSpringBackend.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the service_provided database table.
 * 
 */
@Entity
@Table(name="service_provided")
@NamedQuery(name="ServiceProvided.findAll", query="SELECT s FROM ServiceProvided s")
public class ServiceProvided implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="cost_per_unit")
	private BigDecimal costPerUnit;

	@Column(name="end_time")
	private Timestamp endTime;

	@Lob
	private String notes;

	@Column(name="price_charged")
	private BigDecimal priceCharged;

	@Column(name="start_time")
	private Timestamp startTime;

	private int units;

	//bi-directional many-to-one association to Cas
	@ManyToOne
	@JoinColumn(name="case_id")
	private Cas cas;

	//bi-directional many-to-one association to Service
	@ManyToOne
	private Service service;

	public ServiceProvided() {
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

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public BigDecimal getPriceCharged() {
		return this.priceCharged;
	}

	public void setPriceCharged(BigDecimal priceCharged) {
		this.priceCharged = priceCharged;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public int getUnits() {
		return this.units;
	}

	public void setUnits(int units) {
		this.units = units;
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