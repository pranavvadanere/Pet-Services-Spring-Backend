package com.PetServicesSpringBackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PetServicesSpringBackend.dto.ErrorResponse;
import com.PetServicesSpringBackend.dto.ResponseDTO;
import com.PetServicesSpringBackend.pojos.Owner;
import com.PetServicesSpringBackend.pojos.Pet;
import com.PetServicesSpringBackend.service.IPetService;



@RestController
@RequestMapping("/pet")
@CrossOrigin
public class PetController {

	@Autowired
	private IPetService petService;

	public PetController() {
		System.out.println("in cnstr of " + getClass().getName());
	}

	//to add new pet
	@PostMapping
	public ResponseEntity<?> addNewPetDetails(@RequestBody @Valid Pet transientPet) {
		System.out.println("in add pet " + transientPet);

		try {
			return new ResponseEntity<>(petService.addPet(transientPet), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			System.out.println("err in add " + e);
			return new ResponseEntity<>(new ErrorResponse("Adding pet failed!!!!!", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
//	//to get pet of owners by Ownerid
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getPetDetailsByOwner(@PathVariable Iterable<Integer> Ownerid) {
//		System.out.println("in get pet details of selected owner " + Ownerid);
//		// invoke service method to get pet details
//		try {
//			return ResponseEntity.ok(petService.ownersPet(Ownerid));
//		} catch (RuntimeException e) {
//			System.out.println("err in get " + e);
//			return new ResponseEntity<>(new ErrorResponse("Fetching pet details failed", e.getMessage()),
//					HttpStatus.BAD_REQUEST);
//		}
//
//	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPetDetails(@PathVariable int id) {
		System.out.println("in get pet details " + id);
		// invoke service method to get pet details
		try {
			return ResponseEntity.ok(petService.getPetInfo(id));
		} catch (RuntimeException e) {
			System.out.println("err in get " + e);
			return new ResponseEntity<>(new ErrorResponse("Fetching pet details failed", e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}

	}
	

	//to delete pet
	@DeleteMapping("/{petId}")
	public ResponseEntity<ResponseDTO> deleteOwnerDetails(@PathVariable int petId) {
		System.out.println("in delete pet details " + petId);
	
		return ResponseEntity.ok(new ResponseDTO(petService.deletePetById(petId)));
	}
	
     //to update pet
	
		@PutMapping("/{id}")
		public ResponseEntity<?> updateUserDetails(@RequestBody Pet detachedPet, @PathVariable int id) {
			System.out.println("in update pet " + detachedPet + " " + id);
			try {
				// invoke service layer method for validating owner id
				Pet existingPet = petService.getPetInfo(id);
				// => pet is valid
				// existingPet => pet details fetched from DB (stale)
				// detachedPet => updated pet details from front end.
				return ResponseEntity.ok(petService.updatePet(detachedPet));
			} catch (RuntimeException e) {
				System.out.println("err in get " + e);
				return new ResponseEntity<>(new ErrorResponse("Updating pet details failed", e.getMessage()),
						HttpStatus.BAD_REQUEST);
			}

		}
	
	
	
	
	
}
