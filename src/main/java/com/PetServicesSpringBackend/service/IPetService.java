package com.PetServicesSpringBackend.service;

import java.util.List;

import com.PetServicesSpringBackend.pojos.Pet;

public interface IPetService {
	Pet addPet(Pet pet);
	
	List<Pet> ownersPet(Iterable<Integer> ownerId);
	
	String deletePetById(int petid);

	Pet getPetInfo(int petId);
	
	Pet updatePet(Pet pet);
}
