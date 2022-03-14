package com.qa.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.demo.Entity.AleHouse;
import com.qa.demo.Repo.AleHouseRepo;

@Service
public class AleHouseService implements AleHouseServiceMethods<AleHouse>{

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
	}

	@Override
	public List<AleHouse> readAll() {
		return this.repo.findAll();
	}

	@Override
	public AleHouse readById(long id) {
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
		return null;
	}

	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}