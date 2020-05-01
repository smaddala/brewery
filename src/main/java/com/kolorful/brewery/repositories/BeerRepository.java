package com.kolorful.brewery.repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.kolorful.brewery.domain.Beer;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID>{

}
