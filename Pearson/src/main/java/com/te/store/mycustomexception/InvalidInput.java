package com.te.store.mycustomexception;

public class InvalidInput extends RuntimeException {

	public InvalidInput(String invalidId) {
		super(invalidId);
		
	}

}
