package com.PetServices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.PetServicesSpringBackend.pojos.Owner;



public interface OwnerRepository extends JpaRepository<Owner, Long>  {

	@Query(value = "SELECT o FROM Owner o where o.email=?1 and o.password=?2")
	Owner checkOwnerLogin(String email, String password);
	
	@Modifying
    @Query("UPDATE Owner o SET o.password = :password WHERE o.email = :email")
    int changePassword(@Param("password") String password, @Param("email") String email);
	
	

}
