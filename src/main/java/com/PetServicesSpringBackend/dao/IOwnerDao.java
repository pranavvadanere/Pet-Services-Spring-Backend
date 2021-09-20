package com.PetServicesSpringBackend.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.PetServicesSpringBackend.pojos.Owner;


public interface IOwnerDao extends JpaRepository<Owner, Integer>
{


}
