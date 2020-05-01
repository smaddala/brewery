package com.kolorful.brewery.web.controller;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kolorful.brewery.services.BeerService;
import com.kolorful.brewery.web.model.BeerDto;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	
	@Autowired
	private BeerService service;
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
		
		return new ResponseEntity<>(service.getBeerById(beerId), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity saveNewBeer(@RequestBody   BeerDto beer) {
		
		System.out.println("Beer name" + beer.getBeerName());
		
		BeerDto newBeer = service.saveNewBeer(beer);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newBeer.getId().toString()).toUri();
		
		System.out.println("beer location = " + location.toString());
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", location.toString());
		
		
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity updateBeerById(@PathVariable UUID beerId,
			@RequestBody BeerDto beer) {
		
		service.updateBeer(beerId, beer);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		
		service.deleteBeer(beerId);
		
		
	}

}




