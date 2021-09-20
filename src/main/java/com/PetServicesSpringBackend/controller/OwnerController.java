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
import com.PetServicesSpringBackend.service.IOwnerService;



@RestController
@RequestMapping("/owner")
@CrossOrigin
public class OwnerController {

	@Autowired
	private IOwnerService ownerService;

	public OwnerController() {
		System.out.println("in cnstr of " + getClass().getName());
	}

	//to add new owner
	@PostMapping
	public ResponseEntity<?> addNewOwnerDetails(@RequestBody @Valid Owner transientOwner) {
		System.out.println("in add Owner " + transientOwner);

		try {
			return new ResponseEntity<>(ownerService.addOwner(transientOwner), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			System.out.println("err in add " + e);
			return new ResponseEntity<>(new ErrorResponse("Adding User failed!!!!!", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//toget owner by id
	@GetMapping("/{id}")
	public ResponseEntity<?> getOwnerDetails(@PathVariable int id) {
		System.out.println("in get owner details " + id);
		// invoke service method to get owner details
		try {
			return ResponseEntity.ok(ownerService.getDetails(id));
		} catch (RuntimeException e) {
			System.out.println("err in get " + e);
			return new ResponseEntity<>(new ErrorResponse("Fetching owner details failed", e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}

	}
	
	//to get all owners
	@GetMapping
	public List<Owner> fetchAllOwners() {
		System.out.println("in get all Owner");
		//here we invoke IOwnerService method
		return ownerService.getAllOwner();
	}

	//to delete owner
	@DeleteMapping("/{ownerId}")
	public ResponseEntity<ResponseDTO> deleteOwnerDetails(@PathVariable int ownerId) {
		System.out.println("in delete user details " + ownerId);
	
		return ResponseEntity.ok(new ResponseDTO(ownerService.deleteOwner(ownerId)));
	}
	
     //to update owner
	
		@PutMapping("/{id}")
		public ResponseEntity<?> updateUserDetails(@RequestBody Owner detachedOwner, @PathVariable int id) {
			System.out.println("in update user " + detachedOwner + " " + id);
			try {
				// invoke service layer method for validating owner id
				Owner existingOwner = ownerService.getDetails(id);
				// => owner is valid
				// existingOwner => owner details fetched from DB (stale)
				// detachedOwner => updated owner details from front end.
				return ResponseEntity.ok(ownerService.updateDetails(detachedOwner));
			} catch (RuntimeException e) {
				System.out.println("err in get " + e);
				return new ResponseEntity<>(new ErrorResponse("Updating Owner details failed", e.getMessage()),
						HttpStatus.BAD_REQUEST);
			}

		}
	
	
	
	
	
}
