package com.PetServicesSpringBackend.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cases database table.
 * 
 */
@Entity
@Table(name="cases")
@NamedQuery(name="Cas.findAll", query="SELECT c FROM Cas c")
public class Cas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte closed;

	@Column(name="end_time")
	private Timestamp endTime;

	@Lob
	private String notes;

	@Column(name="start_time")
	private Timestamp startTime;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to Pet
	@ManyToOne
	private Pet pet;

	//bi-directional many-to-one association to CurrentStatus
	@OneToMany(mappedBy="cas")
	private List<CurrentStatus> currentStatuses;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="cas")
	private List<Invoice> invoices;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="cas")
	private List<Note> notesSet;

	//bi-directional many-to-one association to ServicePlanned
	@OneToMany(mappedBy="cas")
	private List<ServicePlanned> servicePlanneds;

	//bi-directional many-to-one association to ServiceProvided
	@OneToMany(mappedBy="cas")
	private List<ServiceProvided> serviceProvideds;

	public Cas() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getClosed() {
		return this.closed;
	}

	public void setClosed(byte closed) {
		this.closed = closed;
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

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Pet getPet() {
		return this.pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public List<CurrentStatus> getCurrentStatuses() {
		return this.currentStatuses;
	}

	public void setCurrentStatuses(List<CurrentStatus> currentStatuses) {
		this.currentStatuses = currentStatuses;
	}

	public CurrentStatus addCurrentStatus(CurrentStatus currentStatus) {
		getCurrentStatuses().add(currentStatus);
		currentStatus.setCas(this);

		return currentStatus;
	}

	public CurrentStatus removeCurrentStatus(CurrentStatus currentStatus) {
		getCurrentStatuses().remove(currentStatus);
		currentStatus.setCas(null);

		return currentStatus;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setCas(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setCas(null);

		return invoice;
	}

	public List<Note> getNotesSet() {
		return this.notesSet;
	}

	public void setNotesSet(List<Note> notesSet) {
		this.notesSet = notesSet;
	}

	public Note addNotesSet(Note notesSet) {
		getNotesSet().add(notesSet);
		notesSet.setCas(this);

		return notesSet;
	}

	public Note removeNotesSet(Note notesSet) {
		getNotesSet().remove(notesSet);
		notesSet.setCas(null);

		return notesSet;
	}

	public List<ServicePlanned> getServicePlanneds() {
		return this.servicePlanneds;
	}

	public void setServicePlanneds(List<ServicePlanned> servicePlanneds) {
		this.servicePlanneds = servicePlanneds;
	}

	public ServicePlanned addServicePlanned(ServicePlanned servicePlanned) {
		getServicePlanneds().add(servicePlanned);
		servicePlanned.setCas(this);

		return servicePlanned;
	}

	public ServicePlanned removeServicePlanned(ServicePlanned servicePlanned) {
		getServicePlanneds().remove(servicePlanned);
		servicePlanned.setCas(null);

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
		serviceProvided.setCas(this);

		return serviceProvided;
	}

	public ServiceProvided removeServiceProvided(ServiceProvided serviceProvided) {
		getServiceProvideds().remove(serviceProvided);
		serviceProvided.setCas(null);

		return serviceProvided;
	}

}