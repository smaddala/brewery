package com.kolorful.brewery.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getters and setters, toString, equals, hashcode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
	
	@Null
	private UUID id;
	
	@NotBlank
	private String beerName;
	
	@NotNull
	private BeerStyleEnum beerStyle;
	
	@NotNull
	private String upc;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Positive
	@NotNull
	@Digits(integer=2, fraction=2)
	private BigDecimal price;
	
	private Integer quantityOnHand;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
	@Null
	private OffsetDateTime createdDate; // UTC time
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
	@Null
	private OffsetDateTime lastModifiedDate; 
	
	
	@Null
	private Integer version;
	
}
