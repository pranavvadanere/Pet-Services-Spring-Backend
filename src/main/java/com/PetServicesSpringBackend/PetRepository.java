package com.PetServices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PetServicesSpringBackend.pojos.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

	
	@Query(value = "SELECT p FROM Pet p where p.id= ?")
	Pet getById(int petId);
	
	@Query(value = "delete p FROM Pet p where p.id= ?")
	String deleteById(int petid);
	
	@Query("update Pet p set p.name =:name,p.birth_date =:birth_date,p.Owner = :Owner,p.species_id =:species_id where p.id =:id")
	 String modifyPet(Pet pet);

	
	
}
