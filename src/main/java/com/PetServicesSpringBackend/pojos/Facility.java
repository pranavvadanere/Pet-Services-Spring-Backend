package com.PetServicesSpringBackend.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the facility database table.
 * 
 */
@Entity
@Table(name="facility")
@NamedQuery(name="Facility.findAll", query="SELECT f FROM Facility f")
public class Facility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	@Column(name="contact_person")
	private String contactPerson;

	private String email;

	@Column(name="facility_name")
	private String facilityName;

	private String phone;

	//bi-directional many-to-one association to Cas
	@OneToMany(mappedBy="facility")
	private List<Cas> cases;

	//bi-directional many-to-one association to Provide
	@OneToMany(mappedBy="facility")
	private List<Provide> provides;

	public Facility() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacilityName() {
		return this.facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Cas> getCases() {
		return this.cases;
	}

	public void setCases(List<Cas> cases) {
		this.cases = cases;
	}

	public Cas addCas(Cas cas) {
		getCases().add(cas);
		cas.setFacility(this);

		return cas;
	}

	public Cas removeCas(Cas cas) {
		getCases().remove(cas);
		cas.setFacility(null);

		return cas;
	}

	public List<Provide> getProvides() {
		return this.provides;
	}

	public void setProvides(List<Provide> provides) {
		this.provides = provides;
	}

	public Provide addProvide(Provide provide) {
		getProvides().add(provide);
		provide.setFacility(this);

		return provide;
	}

	public Provide removeProvide(Provide provide) {
		getProvides().remove(provide);
		provide.setFacility(null);

		return provide;
	}

}