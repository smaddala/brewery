package com.kolorful.brewery.web.mappers;

import org.mapstruct.Mapper;

import com.kolorful.brewery.domain.Beer;
import com.kolorful.brewery.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
	
	public BeerDto beerToBeerDto(Beer beer);
	
	public Beer beerToBeerDto(BeerDto beerDto);
	

}
