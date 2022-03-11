 package com.te.store.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.te.store.dto.Store;
import com.te.store.service.CityComparator;

@Repository
public class StoreDaoImpl implements StoreDao {
	public List<Store> getAllById(String id) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stores.csv"));
		String details = "";
		List<Store> al = new ArrayList<Store>();
		while ((details = br.readLine()) != null) {
			String[] data = details.split(",");
			Store s = new Store();
			s.setStoreId(data[0]);
			s.setPostCode(data[1]);
			s.setCity(data[2]);
			s.setAddress(data[3]);
			s.setOpenedDate(data[4]);
			s.setNoOfOpenedDays(getDays(s.getOpenedDate()));
			if (id.equalsIgnoreCase(data[0])) {
				al.add(s);
			}

		}
		return al;
	}

	 
	public List<Store> getAll() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stores.csv"));
		String details = "";
		List<Store> al = new ArrayList<Store>();
		while ((details = br.readLine()) != null) {
			String[] data = details.split(",");
			Store s = new Store();
			s.setStoreId(data[0]);
			s.setPostCode(data[1]);
			s.setCity(data[2]);
			s.setAddress(data[3]);
			s.setOpenedDate(data[4]);
			s.setNoOfOpenedDays(getDays(s.getOpenedDate()));
			al.add(s);

		}
		Collections.sort(al, new CityComparator());

		return al;
	}
	
	
	
	
	public long getDays(String endDate)throws IOException{
		LocalDate presentDate=LocalDate.now();
        String[] s=endDate.split("-");
        int year=Integer.parseInt(s[2]);
        int month=Integer.parseInt(s[1]);
        int day=Integer.parseInt(s[0]);
		LocalDate oldDate=LocalDate.of(year, month, day);
		long days=ChronoUnit.DAYS.between(oldDate,presentDate);
		return days;
	}

}
