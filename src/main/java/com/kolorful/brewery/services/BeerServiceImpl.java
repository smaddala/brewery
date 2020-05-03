package com.kolorful.brewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.kolorful.brewery.web.model.BeerDto;
import com.kolorful.brewery.web.model.BeerStyleEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerId) {
		
		return BeerDto.builder().id(UUID.randomUUID())
				.beerName("Hawards 5000")
				.beerStyle(BeerStyleEnum.LAGER)
				.build();
		
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beer) {
		return BeerDto.builder().id(UUID.randomUUID())
				.beerName(beer.getBeerName())
				.beerStyle(beer.getBeerStyle())
				.build();
		
	}

	@Override
	public BeerDto updateBeer(UUID beerId, BeerDto beer) {
		return BeerDto.builder().id(UUID.randomUUID())
				.beerName(beer.getBeerName())
				.beerStyle(beer.getBeerStyle())
				.build();
		
		
	}

	@Override
	public void deleteBeer(UUID beerId) {
		// TODO Auto-generated method stub
		log.debug("Inside update beer");
		
	}
	
	

}
