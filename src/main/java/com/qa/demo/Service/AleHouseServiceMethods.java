package com.qa.demo.Service;

import java.util.List;

public interface AleHouseServiceMethods<T> {

<<<<<<< HEAD
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

=======
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
>>>>>>> 28f8bd7aa9af7e41f7d8bc566d13b9890c8cf225
}
