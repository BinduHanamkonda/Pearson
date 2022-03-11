package com.te.store.service;

import java.util.Comparator;

import com.te.store.dto.Store;

public class CityComparator implements Comparator<Store> {

	@Override
	public int compare(Store o1, Store o2) {
		
		return o1.getCity().compareToIgnoreCase(o2.getCity());
	}

}
