package com.qa.demo.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.demo.Entity.AleHouse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AleHouseControllerTest {
	//THIS IS INTEGRATION TESTING 
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void testCreate() throws Exception {

		AleHouse testAleHouse = new AleHouse("Erveluce", "Grilled Chicken", 150, "Yennifer", true);
		String testAleHouseAsJSON = this.mapper.writeValueAsString(testAleHouse);
		RequestBuilder req = post("/AleHouse/create").content(testAleHouseAsJSON)
				.contentType(MediaType.APPLICATION_JSON);

		AleHouse testSavedAleHouse = new AleHouse(2, "Erveluce", "Grilled Chicken", 150, "Yennifer", true);
		String testSavedAleHouseAsJSON = this.mapper.writeValueAsString(testSavedAleHouse);

		ResultMatcher checkAleHouseStatus = status().isCreated();
		ResultMatcher checkAleHouseBody = content().json(testSavedAleHouseAsJSON);

		this.mvc.perform(req).andExpect(checkAleHouseStatus).andExpect(checkAleHouseBody);
	}
	
	@Test
	public void readAll() throws Exception {
		AleHouse entry = new AleHouse("Beauclair white", "Poisoned apple", 100, "Triss", true);
		List<AleHouse> AleHouses = new ArrayList<>();
		AleHouses.add(entry);
		
		String AleHouseOutputAsJSON = this.mapper.writeValueAsString(AleHouses);
		
		this.mvc.perform(get("/alehouse/readAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(AleHouseOutputAsJSON));
	}
	
	@Test
	public void testReadById() throws Exception {
		RequestBuilder request = get("/duck/readById/2");

		ResultMatcher checkStatus = status().isOk();

		AleHouse savedAleHouse = new AleHouse(2, "Erveluce", "Grilled Chicken", 150, "Yennifer", true);
		String savedAleHouseAsJSON = this.mapper.writeValueAsString(savedAleHouse);

		ResultMatcher checkBody = content().json(savedAleHouseAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
}
