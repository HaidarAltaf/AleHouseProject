package com.qa.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.demo.Entity.AleHouse;

@Service
public class AleHouseService implements AleHouseServiceMethods<AleHouse>{

	@Override
	public AleHouse create(AleHouse AleHouse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AleHouse> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AleHouse readById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AleHouse update(long id, AleHouse AleHouse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}


}
