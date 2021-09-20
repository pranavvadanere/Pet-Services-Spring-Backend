package com.PetServicesSpringBackend.service;

import java.util.List;

import com.PetServicesSpringBackend.pojos.Owner;



public interface IOwnerService {
		Owner addOwner(Owner owner);
	
	List<Owner> getAllOwner();

	Owner getDetails(int ownerId);
	
	String deleteOwner(int ownerId);
 
	Owner updateDetails(Owner detachedOwner);
}
