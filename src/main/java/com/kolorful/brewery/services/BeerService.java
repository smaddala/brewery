package com.kolorful.brewery.services;

import java.util.UUID;

import com.kolorful.brewery.web.model.BeerDto;

public interface BeerService {
	
	public BeerDto getBeerById(UUID beerId);

	public BeerDto saveNewBeer(BeerDto beer);

	public void updateBeer(UUID beerId, BeerDto beer);

	public void deleteBeer(UUID beerId);

}
