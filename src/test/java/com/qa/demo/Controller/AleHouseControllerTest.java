package com.qa.demo.Controller;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.assertEquals;
=======
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
>>>>>>> dev
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.demo.Entity.AleHouse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = { "classpath:AleHouse-schema.sql", "classpath:AleHouse-data.sql" })
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
		RequestBuilder req = post("/alehouse/create").contentType(MediaType.APPLICATION_JSON)
				.content(testAleHouseAsJSON);

		AleHouse testSavedAleHouse = new AleHouse(2L, "Erveluce", "Grilled Chicken", 150, "Yennifer", true);
		String testSavedAleHouseAsJSON = this.mapper.writeValueAsString(testSavedAleHouse);

		ResultMatcher checkAleHouseStatus = status().isCreated();
		ResultMatcher checkAleHouseBody = content().json(testSavedAleHouseAsJSON);

		this.mvc.perform(req).andExpect(checkAleHouseStatus).andExpect(checkAleHouseBody);
	}
	
	@Test
	public void readAll() throws Exception {
		AleHouse entry = new AleHouse(1L, "Potion of tir na lia", "Kaedweni stout", 15, "Geralt", true);
		List<AleHouse> AleHouses = new ArrayList<>();
		AleHouses.add(entry);
		
		String AleHouseOutputAsJSON = this.mapper.writeValueAsString(AleHouses);
		
		this.mvc.perform(get("/alehouse/readAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(AleHouseOutputAsJSON));
	}
	  
	@Test
	public void testReadById() throws Exception {
		RequestBuilder request = get("/alehouse/readById/1");

		ResultMatcher checkStatus = status().isOk();

		AleHouse savedAleHouse = new AleHouse(1L, "Potion of tir na lia", "Kaedweni stout", 15, "Geralt", true);
		String savedAleHouseAsJSON = this.mapper.writeValueAsString(savedAleHouse);

		ResultMatcher checkBody = content().json(savedAleHouseAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
<<<<<<< HEAD
	

=======
	@Test
	public void updateTest() throws Exception{
		AleHouse note = new AleHouse(1L, "Potion of tir na lia", "Kaedweni stout", 15, "Geralt", true);
		String notedAleHouseAsJson = this.mapper.writeValueAsString(note);
		
		AleHouse result = new AleHouse(1L, "Potion of tir na lia", "Kaedweni stout", 15, "Geralt", true);
		String resultAleHouseAsJson = this.mapper.writeValueAsString(result);
		
		this.mvc.perform(put("/alehouse/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(notedAleHouseAsJson)).andExpect(status().isAccepted()).andExpect(content().json(resultAleHouseAsJson));
	}
	
	@Test
	public void testDelete() throws Exception {
		AleHouse tavernOrder = new AleHouse(1L, "Potion of tir na lia", "Kaedweni stout", 15, "Geralt", true);
		
		String savedAleHouseAsJSON = this.mapper.writeValueAsString(tavernOrder);
		
		this.mvc.perform(delete("/alehouse/delete/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(savedAleHouseAsJSON));

	}
>>>>>>> dev
}
