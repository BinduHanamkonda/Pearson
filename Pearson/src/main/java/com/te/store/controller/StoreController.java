package com.te.store.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.store.dto.Store;
import com.te.store.dto.StoreResponse;
import com.te.store.service.StoreServiceImpl;

@RestController
public class StoreController {
	@Autowired
	private StoreServiceImpl service;
	@GetMapping("/getstores")
	public ResponseEntity<StoreResponse> getAllByCityOrDate(@RequestParam String sortBy) throws IOException {
		List<Store> stores = service.getAll(sortBy);
		StoreResponse response = new StoreResponse(200, "Successful", "Below is the details of the store you enquired for", stores);
		return new ResponseEntity<StoreResponse>(response,HttpStatus.OK);
	}

	@GetMapping("/getstore")
	public ResponseEntity<StoreResponse> getAllById(@RequestParam String id) throws IOException {
		List<Store> stores = service.getAllByid(id);
		StoreResponse response = new StoreResponse(200, "Successful", "Below is the details of the store you enquired for", stores);
		return new ResponseEntity<StoreResponse>(response,HttpStatus.OK);
	
	}
	
	
}
