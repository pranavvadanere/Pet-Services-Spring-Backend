package com.PetServicesSpringBackend;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.PetServicesSpringBackend.dao.IOwnerDao;
import com.PetServicesSpringBackend.pojos.Owner;
import com.PetServicesSpringBackend.service.IOwnerService;
import com.PetServicesSpringBackend.service.IPetService;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private IOwnerService ownerService;
	
	@Autowired
	private IPetService petService;
	@Autowired
	private IOwnerDao ownerDao;
	@Test
	void contextLoads() {
		
		List<Owner> allOwners = ownerService.getAllOwner();
		System.out.println(allOwners);
		assertEquals(2, allOwners.size());
	}

	@Test
	public void testSaveOwner() throws Exception
	{
		Owner owner=new Owner( 5,"maya@gmail.com ","maya"," kapoor  ",234566742 ,"white goa", 67889);
		
		Owner persistentOwner = ownerDao.save(owner);
		assertEquals(0,persistentOwner.getId());
	}

}
