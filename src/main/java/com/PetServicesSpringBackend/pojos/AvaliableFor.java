package com.PetServicesSpringBackend.pojos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the avaliable_for database table.
 * 
 */
@Entity
@Table(name="avaliable_for")
@NamedQuery(name="AvaliableFor.findAll", query="SELECT a FROM AvaliableFor a")
public class AvaliableFor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Service
	@ManyToOne
	private Service service;

	//bi-directional many-to-one association to Specy
	@ManyToOne
	@JoinColumn(name="species_id")
	private Specy specy;

	public AvaliableFor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Specy getSpecy() {
		return this.specy;
	}

	public void setSpecy(Specy specy) {
		this.specy = specy;
	}

}