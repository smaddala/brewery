package com.kolorful.brewery.web.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.kolorful.brewery.BreweryApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BreweryApplication.class,
                webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BrewaryITTest {
	
	 @LocalServerPort
     private int port;

	@Test
	void test() {
		System.out.println("Server is running at " + port);
	}

}
