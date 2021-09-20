package com.PetServicesSpringBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ResponseDTO {
	public ResponseDTO(String deleteUser) {
		// TODO Auto-generated constructor stub
	}

	private String message;
	
}
