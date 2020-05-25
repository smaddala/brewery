package com.kolorful.brewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.kolorful.brewery.domain.Beer;
import com.kolorful.brewery.repositories.BeerRepository;
import com.kolorful.brewery.web.controller.NotFoundException;
import com.kolorful.brewery.web.mappers.BeerMapper;
import com.kolorful.brewery.web.model.BeerDto;
import com.kolorful.brewery.web.model.BeerStyleEnum;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
	
	private final BeerRepository beerRepo;
	private final BeerMapper beerMapper;
	
	

	@Override
	public BeerDto getBeerById(UUID beerId) {
		
//		return BeerDto.builder().id(UUID.randomUUID())
//				.beerName("Hawards 5000")
//				.beerStyle(BeerStyleEnum.LAGER)
//				.build();
		return beerMapper.beerToBeerDto(
					beerRepo.findById(beerId).orElseThrow(NotFoundException::new)
				);
		
		
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beer) {
//		return BeerDto.builder().id(UUID.randomUUID())
//				.beerName(beer.getBeerName())
//				.beerStyle(beer.getBeerStyle())
//				.build();
	
		return beerMapper.beerToBeerDto(
				beerRepo.save(beerMapper.beerDtoToBeer(beer))
				);
		
		
	}

	@Override
	public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
//		return BeerDto.builder().id(UUID.randomUUID())
//				.beerName(beer.getBeerName())
//				.beerStyle(beer.getBeerStyle())
//				.build();
		
		Beer beer = beerRepo.findById(beerId).orElseThrow(NotFoundException::new);
		
		beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());
        
        return beerMapper.beerToBeerDto(
				beerRepo.save(beer));
        
	}

	@Override
	public void deleteBeer(UUID beerId) {
		// TODO Auto-generated method stub
		log.debug("Inside update beer");
		
	}
	
	

}
