package com.qa.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.demo.Entity.AleHouse;

public interface AleHouseRepo extends JpaRepository<AleHouse, Long>{

}