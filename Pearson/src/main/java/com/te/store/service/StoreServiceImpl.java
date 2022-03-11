package com.te.store.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.store.dao.StoreDaoImpl;
import com.te.store.dto.Store;
import com.te.store.mycustomexception.BlankInput;
import com.te.store.mycustomexception.InvalidInput;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreDaoImpl dao;
	
	
	public List<Store> getAllByid(String id) throws IOException{
		List<Store> store = dao.getAllById(id);
		if(id.isEmpty()) {
			throw new BlankInput("Store Id can't be blank. Please provide a valid id");
		}else if(store.size()<=0) {
			throw new InvalidInput("Invalid store Id. Please try again with a valid store Id");
		}else 
			return store;
	}
	
	public List<Store> getAll(String sortBy) throws IOException{
		List<Store> stores = dao.getAll();
		if(sortBy.equalsIgnoreCase("city")) {
			Collections.sort(stores, new CityComparator());
			return stores;
		}else if(sortBy.equalsIgnoreCase("Openeddate") || sortBy.equalsIgnoreCase("Opened date")) {
			Collections.sort(stores, new DateComparator());
			return stores;
		}else throw new BlankInput("Please let us know if you want to sort the stores by Openeddate or the City");
	}
	
   
}

