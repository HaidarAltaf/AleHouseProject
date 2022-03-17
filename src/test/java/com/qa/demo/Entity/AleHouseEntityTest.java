package com.qa.demo.Entity;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AleHouseEntityTest {

	@Test
	public void testAll() {
		EqualsVerifier.forClass(AleHouse.class).usingGetClass().verify();
		;
	}
	
	@Test
	public void GetterAndSetterTest() {
		AleHouse alehouse = new AleHouse(4, "Chicken", "Zerrikanian spirit", 5, "Ciri", true);
		
		assertNotNull(alehouse.getId());
		assertNotNull(alehouse.getDrink());
		assertNotNull(alehouse.getFood());
		assertNotNull(alehouse.isGameOfGwent());
		assertNotNull(alehouse.getName());
		assertNotNull(alehouse.getPrice());
		
		assertEquals(alehouse.getId(), 4);
		assertEquals(alehouse.getFood(), "Chicken");
		assertEquals(alehouse.getDrink(), "Zerrikanian spirit");
		assertEquals(alehouse.getPrice(), 5);
		assertEquals(alehouse.getName(), "Ciri");
		assertEquals(alehouse.isGameOfGwent(), true);
	
	}

}
