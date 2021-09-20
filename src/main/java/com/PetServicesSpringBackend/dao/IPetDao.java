package com.PetServicesSpringBackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PetServicesSpringBackend.pojos.Pet;

public interface IPetDao  extends JpaRepository<Pet, Integer>{


}
