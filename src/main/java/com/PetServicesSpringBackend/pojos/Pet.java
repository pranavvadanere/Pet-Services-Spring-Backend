package com.PetServicesSpringBackend.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pet database table.
 * 
 */
@Entity
@Table(name="pet")
@NamedQuery(name="Pet.findAll", query="SELECT p FROM Pet p")
public class Pet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	private Date birthDate;

	

	@Lob
	private String notes;

	//bi-directional many-to-one association to Cas
	@OneToMany(mappedBy="pet")
	private List<Cas> cases;

	//bi-directional many-to-one association to Owner
	@ManyToOne
	private Owner owner;

	//bi-directional many-to-one association to Specy
	@ManyToOne
	@JoinColumn(name="species_id")
	private Specy specy;

	public Pet() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<Cas> getCases() {
		return this.cases;
	}

	public void setCases(List<Cas> cases) {
		this.cases = cases;
	}

	public Cas addCas(Cas cas) {
		getCases().add(cas);
		cas.setPet(this);

		return cas;
	}

	public Cas removeCas(Cas cas) {
		getCases().remove(cas);
		cas.setPet(null);

		return cas;
	}

	public Owner getOwner() {
		return this.owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Specy getSpecy() {
		return this.specy;
	}

	public void setSpecy(Specy specy) {
		this.specy = specy;
	}

}