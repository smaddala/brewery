package com.kolorful.brewery.web.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kolorful.brewery.services.CustomerService;
import com.kolorful.brewery.web.model.BeerDto;
import com.kolorful.brewery.web.model.CustomerDto;


@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService custService;
	
	@GetMapping("/{custId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID custId) {
		
		return new ResponseEntity<>(custService.getCustomerById(custId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity createCustomer(@Valid @RequestBody CustomerDto customer) {
		
		System.out.println("Customer name" + customer.getCustName());
		
		
		CustomerDto newCust = custService.saveNewCust(customer);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newCust.getCustId().toString()).toUri();
		
		System.out.println("beer location = " + location.toString());
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", location.toString());
		
		
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{custId}")
	public ResponseEntity handleUpdate(@PathVariable UUID custId,
			@Valid @RequestBody BeerDto beer) {
		
		custService.updateCustomer(custId, beer);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{custId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID custId) {
		
		custService.deleteCustomer(custId);
		
	}
	
	

}
