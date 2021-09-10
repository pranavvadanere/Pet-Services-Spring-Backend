package com.PetServicesSpringBackend.dao;

import com.PetServicesSpringBackend.pojos.Owner;

public interface IOwnerDao {
	String addOwner(Owner owener);

	String modifyOwner(Owner owner);

}
