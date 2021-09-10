package com.PetServicesSpringBackend.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the service database table.
 * 
 */
@Entity
@Table(name="service")
@NamedQuery(name="Service.findAll", query="SELECT s FROM Service s")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="cost_per_unit")
	private BigDecimal costPerUnit;

	@Column(name="has_limit")
	private byte hasLimit;

	@Column(name="service_name")
	private String serviceName;

	//bi-directional many-to-one association to AvaliableFor
	@OneToMany(mappedBy="service")
	private List<AvaliableFor> avaliableFors;

	//bi-directional many-to-one association to Provide
	@OneToMany(mappedBy="service")
	private List<Provide> provides;

	//bi-directional many-to-one association to Unit
	@ManyToOne
	private Unit unit;

	//bi-directional many-to-one association to ServicePlanned
	@OneToMany(mappedBy="service")
	private List<ServicePlanned> servicePlanneds;

	//bi-directional many-to-one association to ServiceProvided
	@OneToMany(mappedBy="service")
	private List<ServiceProvided> serviceProvideds;

	public Service() {
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

	public byte getHasLimit() {
		return this.hasLimit;
	}

	public void setHasLimit(byte hasLimit) {
		this.hasLimit = hasLimit;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public List<AvaliableFor> getAvaliableFors() {
		return this.avaliableFors;
	}

	public void setAvaliableFors(List<AvaliableFor> avaliableFors) {
		this.avaliableFors = avaliableFors;
	}

	public AvaliableFor addAvaliableFor(AvaliableFor avaliableFor) {
		getAvaliableFors().add(avaliableFor);
		avaliableFor.setService(this);

		return avaliableFor;
	}

	public AvaliableFor removeAvaliableFor(AvaliableFor avaliableFor) {
		getAvaliableFors().remove(avaliableFor);
		avaliableFor.setService(null);

		return avaliableFor;
	}

	public List<Provide> getProvides() {
		return this.provides;
	}

	public void setProvides(List<Provide> provides) {
		this.provides = provides;
	}

	public Provide addProvide(Provide provide) {
		getProvides().add(provide);
		provide.setService(this);

		return provide;
	}

	public Provide removeProvide(Provide provide) {
		getProvides().remove(provide);
		provide.setService(null);

		return provide;
	}

	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public List<ServicePlanned> getServicePlanneds() {
		return this.servicePlanneds;
	}

	public void setServicePlanneds(List<ServicePlanned> servicePlanneds) {
		this.servicePlanneds = servicePlanneds;
	}

	public ServicePlanned addServicePlanned(ServicePlanned servicePlanned) {
		getServicePlanneds().add(servicePlanned);
		servicePlanned.setService(this);

		return servicePlanned;
	}

	public ServicePlanned removeServicePlanned(ServicePlanned servicePlanned) {
		getServicePlanneds().remove(servicePlanned);
		servicePlanned.setService(null);

		return servicePlanned;
	}

	public List<ServiceProvided> getServiceProvideds() {
		return this.serviceProvideds;
	}

	public void setServiceProvideds(List<ServiceProvided> serviceProvideds) {
		this.serviceProvideds = serviceProvideds;
	}

	public ServiceProvided addServiceProvided(ServiceProvided serviceProvided) {
		getServiceProvideds().add(serviceProvided);
		serviceProvided.setService(this);

		return serviceProvided;
	}

	public ServiceProvided removeServiceProvided(ServiceProvided serviceProvided) {
		getServiceProvideds().remove(serviceProvided);
		serviceProvided.setService(null);

		return serviceProvided;
	}

}