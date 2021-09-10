package com.PetServicesSpringBackend.dao;

import java.util.List;

import com.PetServicesSpringBackend.pojos.Pet;

public interface IPetDao {
	String addPet(Pet pet);
	String deletePet(int petid);
	List<Pet> ownersPet(int userId);
	Pet getPetInfo(int petId);
	String modifyPet(Pet pet);

}
