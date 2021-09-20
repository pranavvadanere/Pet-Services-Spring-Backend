package com.PetServicesSpringBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PetServicesSpringBackend.dao.IOwnerDao;
import com.PetServicesSpringBackend.pojos.Owner;


@Service
@Transactional
public class OwnerServiceImpl implements IOwnerService {

	@Autowired
	private IOwnerDao ownerDao;
	
	@Override
	public Owner addOwner(Owner owner) {
		
		return ownerDao.save(owner);
	}

	@Override
	public List<Owner> getAllOwner() {
		
		return ownerDao.findAll();
	}

	@Override
	public Owner getDetails(int ownerId) {
		// TODO Auto-generated method stub
		return ownerDao.getById(ownerId);
				
	}

	@Override
	public String deleteOwner(int ownerId) {
		
		 ownerDao.deleteById(ownerId);
		return "Owner details deleted for ID=" + ownerId;
	}

	@Override
	public Owner updateDetails(Owner detachedOwner) {
	
		return ownerDao.save(detachedOwner) ;
	}

}
