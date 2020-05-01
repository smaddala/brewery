package com.kolorful.brewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
public class BeerControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void getBeerById() throws Exception {
		
		mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID()))
				.andExpect(status().isOk());
		
	}

}
