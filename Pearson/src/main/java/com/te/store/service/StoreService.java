package com.te.store.service;

import java.io.IOException;
import java.util.List;

import com.te.store.dto.Store;

public interface StoreService {
	
	public List<Store> getAllByid(String id) throws IOException;
	public List<Store> getAll(String sortBy) throws IOException;
		
	

}
