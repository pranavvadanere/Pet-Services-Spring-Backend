package com.PetServicesSpringBackend.pojos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the provides database table.
 * 
 */
@Entity
@Table(name="provides")
@NamedQuery(name="Provide.findAll", query="SELECT p FROM Provide p")
public class Provide implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="currently_used")
	private int currentlyUsed;

	@Column(name="service_limit")
	private int serviceLimit;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to Service
	@ManyToOne
	private Service service;

	public Provide() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurrentlyUsed() {
		return this.currentlyUsed;
	}

	public void setCurrentlyUsed(int currentlyUsed) {
		this.currentlyUsed = currentlyUsed;
	}

	public int getServiceLimit() {
		return this.serviceLimit;
	}

	public void setServiceLimit(int serviceLimit) {
		this.serviceLimit = serviceLimit;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

}