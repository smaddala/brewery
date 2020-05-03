package com.kolorful.brewery.web.controller;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kolorful.brewery.services.BeerService;
import com.kolorful.brewery.web.model.BeerDto;
import com.kolorful.brewery.web.model.BeerStyleEnum;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
	
	@MockBean
	BeerService beerService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
    ObjectMapper objectMapper;

	@Test
	void getBeerById() throws Exception {
		
		given(beerService.getBeerById(any())).willReturn(getValidBeerDto());
		
		mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()))
				.andExpect(status().isOk());

		
	}
	
	@Test
	void saveNewBeer() throws Exception {
		
		 BeerDto beerDto = getValidBeerDto();
	     String beerDtoJsonStr = objectMapper.writeValueAsString(beerDto);
	     
	     given(beerService.saveNewBeer(any())).willReturn(getValidBeerDto());
	    
		
	     mockMvc.perform(post("/api/v1/beer")
	    		 .contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJsonStr))
				.andExpect(status().isCreated());
				
		
	}
	
	@Test
    void updateBeerById() throws Exception {
		
	    
		given(beerService.updateBeer(any(),any())).willReturn(getValidBeerDto());

        BeerDto beerDto = getValidBeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());
    }

	private BeerDto getValidBeerDto() {
		// TODO Auto-generated method stub
		return BeerDto.builder()
				
				.beerName("My beer")
				.beerStyle(BeerStyleEnum.ALE)
				.price(new BigDecimal(10.99).setScale(2, RoundingMode.HALF_EVEN))
				.upc("UPC1")
				.build();
				
				
	}

}
