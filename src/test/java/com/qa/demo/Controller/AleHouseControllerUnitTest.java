package com.qa.demo.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.demo.Entity.AleHouse;
import com.qa.demo.Service.AleHouseService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AleHouseControllerUnitTest {
	
	@Autowired
	private AleHouseController controller;

	@MockBean
	private AleHouseService service;

	@Test
	public void createTest() {
		AleHouse AleHouse = new AleHouse("Viziman Champion", "Fondue", 74, "Zoltan Chivay", true);

		Mockito.when(this.service.create(AleHouse)).thenReturn(AleHouse);

		ResponseEntity<AleHouse> response = new ResponseEntity<AleHouse>(AleHouse, HttpStatus.CREATED);

		assertThat(response).isEqualTo(this.controller.createAleHouse(AleHouse));

		Mockito.verify(this.service, times(1)).create(AleHouse);
	}

	@Test
	public void updateTest() throws Exception {
		AleHouse AleHouse = new AleHouse(1L, "Viziman Champion", "Fondue and cheese", 74, "Zoltan Chivay", true);
		AleHouse AleHouse3 = new AleHouse("Viziman Champion", "Fondue and cheese", 74, "Zoltan Chivay", true);

		Mockito.when(this.service.update(1L, AleHouse3)).thenReturn(AleHouse);
		
		ResponseEntity<AleHouse> response = new ResponseEntity<AleHouse>(AleHouse, HttpStatus.ACCEPTED);
		
		assertThat(response).isEqualTo(this.controller.updateAleHouse(1L, AleHouse3));

		Mockito.verify(this.service, times(1)).update(1L, AleHouse3);
	}

	@Test
	public void readAllTest() throws Exception {
		AleHouse entry = new AleHouse(1L, "Potion of tir na lia", "Kaedweni stout", 15, "Geralt", true);
		List<AleHouse> AleHouses = new ArrayList<>();
		AleHouses.add(entry);
		
		Mockito.when(this.service.readAll()).thenReturn(AleHouses);

		ResponseEntity<List<AleHouse>> response = new ResponseEntity<List<AleHouse>>(AleHouses, HttpStatus.OK);

		assertThat(response).isEqualTo(this.controller.readAll());

		Mockito.verify(this.service, times(1)).readAll();
	}

	@Test
	public void readByIdTest() throws Exception {
		AleHouse AleHouse = new AleHouse(1L, "Potion of tir na lia", "Kaedweni stout", 15, "Geralt", true);

		Mockito.when(this.service.readById(Mockito.anyLong())).thenReturn(AleHouse);

		ResponseEntity<AleHouse> response = new ResponseEntity<AleHouse>(AleHouse, HttpStatus.OK);

		assertThat(response).isEqualTo(this.controller.readById(Mockito.anyLong()));

		Mockito.verify(this.service, times(1)).readById(Mockito.anyLong());
	}

	@Test
	public void deleteTest() throws Exception {
		AleHouse AleHouse = new AleHouse("Raspberry juice", "Wyvern meat", 47, "Emhyr Var Emreis", true);
		
		Mockito.when(this.service.delete(Mockito.anyLong())).thenReturn(true);
		
//		ResponseEntity<AleHouse> response = new ResponseEntity<AleHouse>(AleHouse, HttpStatus.NO_CONTENT);

//		assertThat(response).isEqualTo(this.controller.delete(Mockito.anyLong()));
		
		assertTrue(this.service.delete(Mockito.anyLong()));

		Mockito.verify(this.service, Mockito.times(1)).delete(Mockito.anyLong());
	}

}
