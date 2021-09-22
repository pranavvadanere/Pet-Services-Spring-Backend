package com.PetServicesSpringBackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.PetServicesSpringBackend.dao.IOwnerDao;
import com.PetServicesSpringBackend.pojos.Owner;
import com.PetServicesSpringBackend.pojos.Pet;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}


@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private IOwnerDao ownerDao;
	private List<Pet> tommy;

	@Override
	public void run(String... args) throws Exception {

	 Owner o = new Owner();
	 o.setEmail("o1@gmail.com");
	 o.setFirstName("nivya");
	 o.setLastName("Mahale");
	 o.setId(4);
	 o.setMobile("234567");
	 o.setNotes("furrr cat");
	 o.setPhone("3456");
	 o.setPets(tommy);
	
		ownerDao.save(o);
	

		
	}
	}