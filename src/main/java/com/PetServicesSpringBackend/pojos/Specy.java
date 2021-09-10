package com.PetServicesSpringBackend.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the species database table.
 * 
 */
@Entity
@Table(name="species")
@NamedQuery(name="Specy.findAll", query="SELECT s FROM Specy s")
public class Specy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="species_name")
	private String speciesName;

	//bi-directional many-to-one association to AvaliableFor
	@OneToMany(mappedBy="specy")
	private List<AvaliableFor> avaliableFors;

	//bi-directional many-to-one association to Pet
	@OneToMany(mappedBy="specy")
	private List<Pet> pets;

	public Specy() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpeciesName() {
		return this.speciesName;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	public List<AvaliableFor> getAvaliableFors() {
		return this.avaliableFors;
	}

	public void setAvaliableFors(List<AvaliableFor> avaliableFors) {
		this.avaliableFors = avaliableFors;
	}

	public AvaliableFor addAvaliableFor(AvaliableFor avaliableFor) {
		getAvaliableFors().add(avaliableFor);
		avaliableFor.setSpecy(this);

		return avaliableFor;
	}

	public AvaliableFor removeAvaliableFor(AvaliableFor avaliableFor) {
		getAvaliableFors().remove(avaliableFor);
		avaliableFor.setSpecy(null);

		return avaliableFor;
	}

	public List<Pet> getPets() {
		return this.pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public Pet addPet(Pet pet) {
		getPets().add(pet);
		pet.setSpecy(this);

		return pet;
	}

	public Pet removePet(Pet pet) {
		getPets().remove(pet);
		pet.setSpecy(null);

		return pet;
	}

}