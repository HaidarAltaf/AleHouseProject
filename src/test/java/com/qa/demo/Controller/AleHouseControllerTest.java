package com.qa.demo.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = { "classpath:AleHouse-schema.sql",
"classpath:AleHouse-data.sql" })
public class AleHouseControllerTest {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void testCreate() throws Exception {
		AleHouse testAleHouse = new AleHouse("Erveluce", "Grilled Chicken", 150, "Yennifer", true);
		String testAleHouseAsJSON = this.mapper.writeValueAsString(testAleHouse);
		RequestBuilder req = post("/alehouse/create").content(testAleHouseAsJSON)
				.contentType(MediaType.APPLICATION_JSON);

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
		
		String entryAsJSON = this.mapper.writeValueAsString(AleHouses);
		
		this.mvc.perform(get("/alehouse/readAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void readById() throws Exception {
		AleHouse testSavedalehouse = new AleHouse(1L, "Potion of tir na lia", "Kaedweni stout", 15, "Geralt", true);
		String testSavedalehouseasJSON = this.mapper.writeValueAsString(testSavedalehouse);
		
		RequestBuilder request = get("/alehouse/readById/1");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testSavedalehouseasJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void updateTest() throws Exception{
		AleHouse note = new AleHouse("Potion of tir na lia", "Kaedweni stout", 15, "Geralt", true);
		String notedAleHouseAsJson = this.mapper.writeValueAsString(note);
//		List<AleHouse> AleHouses = new ArrayList<>();

		AleHouse result = new AleHouse(1L, "Potion of tir na lia", "Kaedweni stout", 15, "Geralt", true);
		String resultAleHouseAsJson = this.mapper.writeValueAsString(result);
		
		this.mvc.perform(put("/alehouse/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(notedAleHouseAsJson)).andExpect(status().isAccepted())
				.andExpect(content().json(resultAleHouseAsJson));
		}
	
	@Test
	public void testDelete() throws Exception {
//		AleHouse tavernOrder = new AleHouse(1L, "Potion of tir na lia", "Kaedweni stout", 15, "Geralt", true);
//		String savedAleHouseAsJSON = this.mapper.writeValueAsString(tavernOrder);
		
		this.mvc.perform(delete("/alehouse/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());

	}
}
