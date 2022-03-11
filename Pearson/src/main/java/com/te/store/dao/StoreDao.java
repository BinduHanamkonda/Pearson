package com.te.store.dao;
import java.io.IOException;
import java.util.List;
import com.te.store.dto.Store;


public interface StoreDao {

	public List<Store> getAllById(String id) throws IOException;
	public List<Store> getAll() throws IOException;
}
