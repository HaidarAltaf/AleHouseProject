package com.qa.demo.Service;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> service

import org.springframework.stereotype.Service;

import com.qa.demo.Entity.AleHouse;
<<<<<<< HEAD
=======
import com.qa.demo.Repo.AleHouseRepo;
>>>>>>> service

@Service
public class AleHouseService implements AleHouseServiceMethods<AleHouse>{

<<<<<<< HEAD
	@Override
	public AleHouse create(AleHouse AleHouse) {
		// TODO Auto-generated method stub
		return null;
=======
	private AleHouseRepo repo;

	public AleHouseService(AleHouseRepo repo) {
		this.repo = repo;
	}

	public AleHouseRepo getRepo() {
		return repo;
	}

	public void setRepo(AleHouseRepo repo) {
		this.repo = repo;
	}

	@Override
	public AleHouse create(AleHouse AleHouse) {
		return this.repo.save(AleHouse);
>>>>>>> service
	}

	@Override
	public List<AleHouse> readAll() {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return null;
=======
		return this.repo.findAll();
>>>>>>> service
	}

	@Override
	public AleHouse readById(long id) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AleHouse update(long id, AleHouse AleHouse) {
		// TODO Auto-generated method stub
=======
		Optional<AleHouse> AleHouseId = this.repo.findById(id);
		if(AleHouseId.isPresent()){
			return AleHouseId.get();
		}
		return null;
	}

	@Override 
	public AleHouse update(long id, AleHouse AleHouse) {
		Optional<AleHouse> existing = this.repo.findById(id);
		if(existing.isPresent()) {
			AleHouse existance = existing.get();
			existance.setId(id);
			existance.setDrink(existance.getDrink());
			existance.setFood(existance.getFood());
			existance.setName(existance.getName());
			existance.setPrice(existance.getPrice());
			existance.setGameOfGwent(true);
			return this.repo.saveAndFlush(existance);
		}
>>>>>>> service
		return null;
	}

	@Override
	public boolean delete(long id) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return false;
	}

}
=======
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
>>>>>>> service
