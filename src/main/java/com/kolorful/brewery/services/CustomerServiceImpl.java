package com.kolorful.brewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.kolorful.brewery.web.model.BeerDto;
import com.kolorful.brewery.web.model.CustomerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		return CustomerDto.builder().custId(customerId)
				.custName("cherry")
				.build();
	}

	@Override
	public CustomerDto saveNewCust(CustomerDto customer) {
		return CustomerDto.builder().custId(UUID.randomUUID())
				.custName(customer.getCustName())
				.build();
		
	}

	@Override
	public void updateCustomer(UUID custId, BeerDto beer) {
		
		log.debug("update customer for id" + custId);
		
	}

	@Override
	public void deleteCustomer(UUID custId) {
		
		log.debug("delete customer for id" + custId);
		
	}

}
