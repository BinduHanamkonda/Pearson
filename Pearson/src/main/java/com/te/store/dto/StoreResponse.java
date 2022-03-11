package com.te.store.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<Store> store;
	
	
	public StoreResponse(int statusCode, String message, String description) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.description = description;
	}
	
	
	 
	
}