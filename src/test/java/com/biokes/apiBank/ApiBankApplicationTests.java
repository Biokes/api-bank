package com.biokes.apiBank;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.biokes.apiBank.config.Jobs.getMostRecentThursday;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApiBankApplicationTests {
	@Test
	void testLastThursdayDate(){
		assertEquals("2025-01-02", getMostRecentThursday().toString());
	}

}
