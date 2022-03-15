package com.qa.demo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.Entity.AleHouse;
import com.qa.demo.Service.AleHouseService;


@RestController
@RequestMapping("/alehouse")
public class AleHouseController {
	
	private AleHouseService service;

	private AleHouseController(AleHouseService service) {
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<AleHouse> createAleHouse(@RequestBody AleHouse AleHouse) {
		return new ResponseEntity<AleHouse>(this.service.create(AleHouse), HttpStatus.CREATED);
	}
  
	@PutMapping("/update/{id}")
	public ResponseEntity<AleHouse> updateAleHouse(@PathVariable long id, @RequestBody AleHouse AleHouse){
		return new ResponseEntity<AleHouse>(this.service.update(id, AleHouse), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/readById/{id}")
	public ResponseEntity<AleHouse> readById(@PathVariable long id){
		return new ResponseEntity<AleHouse>(this.service.readById(id), HttpStatus.OK);
	}
	
	@GetMapping("/readAll")
	public ResponseEntity<List<AleHouse>> readAll() {
		return new ResponseEntity<List<AleHouse>>(this.service.readAll(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteAleHouse(@PathVariable long id) {
		if (this.service.delete(id) == true) {
			new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		} else {
			new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		}
		return null;
	}

}
