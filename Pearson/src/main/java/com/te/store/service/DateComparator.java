package com.te.store.service;

import java.util.Comparator;

import com.te.store.dto.Store;

public class DateComparator implements Comparator<Store>{

	@Override
	public int compare(Store o1, Store o2) {
		return o1.getNoOfOpenedDays().compareTo(o2.getNoOfOpenedDays());
	}

}
