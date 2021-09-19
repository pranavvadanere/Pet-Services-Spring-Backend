package com.PetServicesSpringBackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PetServices.Repository.OwnerRepository;
import com.PetServicesSpringBackend.pojos.Owner;

@Service
@Transactional
public class OwnerDaoImpl implements IOwnerDao {

	@Autowired
	private OwnerRepository ownerRepository;

	@Override
	public Owner addOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public Owner validateOwner(String email, String password) {
		if (email != null && password != null) {
			return ownerRepository.checkOwnerLogin(email, password);
		}
		return null;

	}

	@Override
	public int changePassword(String password, String email) {
		return ownerRepository.changePassword(password, email);

	}

}
