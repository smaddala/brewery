package com.kolorful.brewery.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kolorful.brewery.domain.Beer;
import com.kolorful.brewery.repositories.BeerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner{
	
	 public static final Long BEER_1_UPC = 0631234200036L;
	 public static final Long BEER_2_UPC = 063123430001L;
	 public static final Long BEER_3_UPC = 0631234200L;

	private final BeerRepository beerRepo;
	
	@Override
	public void run(String... args) throws Exception {
		loadBeer();
		
	}

	private void loadBeer() {
		System.out.println("entering loadBeer");
		
		if(beerRepo.count() == 0 ) {
			Beer b1 = Beer.builder()
	                .beerName("Mango Bobs")
	                .beerStyle("IPA")
	                .minOnHand(12)
	                .quantityToBrew(200)
	                .price(new BigDecimal("12.95"))
	                .upc( BEER_1_UPC)
	                .build();

	        Beer b2 = Beer.builder()
	                .beerName("Galaxy Cat")
	                .beerStyle("PALE_ALE")
	                .minOnHand(12)
	                .quantityToBrew(200)
	                .price(new BigDecimal("12.95"))
	                .upc(BEER_2_UPC)
	                .build();

	        Beer b3 = Beer.builder()
	                .beerName("Pinball Porter")
	                .beerStyle("PALE_ALE")
	                .minOnHand(12)
	                .quantityToBrew(200)
	                .price(new BigDecimal("12.95"))
	                .upc(BEER_3_UPC)
	                .build();

	        beerRepo.save(b1);
	        beerRepo.save(b2);
	        beerRepo.save(b3);
	        
	        System.out.println("Leaving loadBeer " + beerRepo.count());
		}
		
	}

}
