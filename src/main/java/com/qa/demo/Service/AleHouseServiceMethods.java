package com.qa.demo.Service;

import java.util.List;

public interface AleHouseServiceMethods<T> {

	//CREATE
		T create(T AleHouse);

		//READ ALL
		List<T>readAll();
		
		//READ BY ID
		T readById(long id);
		
		//UPDATE	
		T update(long id, T AleHouse);
		
		//DELETE
		boolean delete(long id);
}
