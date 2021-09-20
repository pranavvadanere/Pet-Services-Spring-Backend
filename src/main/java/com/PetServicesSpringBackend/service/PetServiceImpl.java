package com.PetServicesSpringBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PetServicesSpringBackend.dao.IPetDao;
import com.PetServicesSpringBackend.pojos.Pet;

@Service
@Transactional
public class PetServiceImpl implements IPetService {

	@Autowired
	private IPetDao petDao;
	
	@Override
	public Pet addPet(Pet pet) {
		return petDao.save(pet);
	}

	@Override
	public List<Pet> ownersPet(Iterable<Integer> ownerId) {
		return petDao.findAllById(ownerId);
	}

	@Override
	public String deletePetById(int petId) {
		petDao.deleteById(petId);
		return "Pet details deleted for ID=" + petId;
	}

	@Override
	public Pet getPetInfo(int petId) {
		return petDao.getById(petId);
	}

	@Override
	public Pet updatePet(Pet updatedPet) {
	      
		return petDao.save(updatedPet);
	}

}
