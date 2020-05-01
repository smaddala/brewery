package com.kolorful.brewery.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getters and setters
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
	
	private UUID id;
	private String beerName;
	private BeerStyleEnum beerStyle;
	private String upc;
	private BigDecimal price;
	private Integer quantityOnHand;
	private OffsetDateTime createdDate; // UTC time
	private OffsetDateTime lastModifiedDate; 
	private Integer version;
	
}
