package com.PetServicesSpringBackend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.PetServices.Repository.PetRepository;
import com.PetServicesSpringBackend.pojos.Pet;

public class PetDaoImpl implements IPetDao {
	
	@Autowired
	private PetRepository petRepository;

	
	@Override
	public Pet addPet(Pet pet) {
		
		return petRepository.save(pet);
	}

	@Override
	public String deletePetById(int petid) {
		
		return petRepository.deleteById(petid);
	}

	@Override
	public List<Pet> ownersPet(int userId) {
		
		return petRepository.findAll();
	}

	@Override
	public Pet getPetInfo(int petId) {
		
		return petRepository.getById(petId);
	}

	@Override
	public String modifyPet(Pet pet) {
		
		return petRepository.modifyPet(pet);
	}

}
