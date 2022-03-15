package com.qa.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.demo.Entity.AleHouse;
import com.qa.demo.Repo.AleHouseRepo;

@SpringBootTest
public class AleHouseServiceTest {
	//THIS IS UNIT TESTING
	
	@Autowired
	private AleHouseService service;
	
	@MockBean
	private AleHouseRepo repo;
	
	@Test
	public void createTest() {
		AleHouse orders = new AleHouse("Beauclair white", "Poisoned apple", 100, "Triss", true);
		AleHouse outgoings = new AleHouse(3, "Beauclair white", "Poisoned apple", 100, "Triss", true);

		Mockito.when(this.repo.save(orders)).thenReturn(outgoings);

		assertEquals(outgoings, this.service.create(orders));

		Mockito.verify(this.repo, Mockito.times(1)).save(orders);
	}
	
	@Test
	public void updateTest() {
		Optional<AleHouse> optionalOutgoings = Optional.of (new AleHouse(1L, "Raspberry juice", "Wyvern meat", 41, "Emhyr", true));
		AleHouse orders = new AleHouse("Raspberry juice", "Wyvern meat", 41, "Emhyr Var Emreis", true);
		AleHouse outgoings = new AleHouse(1L, "Raspberry juice", "Wyvern meat", 41, "Emhyr Var Emreis", true);
		
		Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(optionalOutgoings);
		Mockito.when(this.repo.saveAndFlush(outgoings)).thenReturn(outgoings);
		
		assertEquals(outgoings, this.service.update(Mockito.anyLong(), orders));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(outgoings);
	}
	
	@Test
    public void readAllTest() {
        AleHouse outgoings = new AleHouse (3L, "Poisoned apple", "Beauclair white",  100, "Triss", true);
        List<AleHouse> tavern = new ArrayList<>();
        tavern.add(outgoings);
        
        Mockito.when(this.repo.findAll()).thenReturn(tavern);
        
        assertEquals(tavern, this.service.readAll());
        
        Mockito.verify(this.repo, Mockito.times(1)).findAll();
    }
	  
	@Test
	public void readByIdTest() {
		Optional<AleHouse> optionalOutgoings = Optional.of(new AleHouse("Raspberry juice", "Wyvern meat", 41, "Emhyr Var Emreis", true));
		AleHouse outgoings = new AleHouse("Raspberry juice", "Wyvern meat", 41, "Emhyr Var Emreis", true);
		
		Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(optionalOutgoings);

		assertEquals(outgoings, this.service.readById(Mockito.anyLong()));

		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
	}
	
	@Test
	public void deleteTrueTest() {
		Mockito.when(this.repo.existsById(Mockito.anyLong())).thenReturn(false);
		
		assertTrue(this.service.delete(Mockito.anyLong()));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(Mockito.anyLong());
		Mockito.verify(this.repo, Mockito.times(1)).existsById(Mockito.anyLong());
	}

	@Test
	public void deleteFalseTest() {
		Mockito.when(this.repo.existsById(Mockito.anyLong())).thenReturn(true);
		
		assertFalse(this.service.delete(Mockito.anyLong()));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(Mockito.anyLong());
		Mockito.verify(this.repo, Mockito.times(1)).existsById(Mockito.anyLong());
	}

}
