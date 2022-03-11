package com.te.store.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store  {
	
	private String storeId;
	private String postCode;
	private String city;
	private String address;
	private String openedDate;
	private Long noOfOpenedDays;
	
}
