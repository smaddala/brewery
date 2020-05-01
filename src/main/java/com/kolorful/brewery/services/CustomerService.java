package com.kolorful.brewery.services;

import java.util.UUID;

import com.kolorful.brewery.web.model.BeerDto;
import com.kolorful.brewery.web.model.CustomerDto;

public interface CustomerService {
	
	public CustomerDto getCustomerById(UUID customerId);

	public CustomerDto saveNewCust(CustomerDto customer);

	public void updateCustomer(UUID custId, BeerDto beer);

	public void deleteCustomer(UUID custId);

}
