package com.belajar.retrofit;

import com.belajar.retrofit.controller.GanderizeController;
import com.belajar.retrofit.dto.BaseResponse;
import com.belajar.retrofit.dto.GenderizeResponse;
import com.belajar.retrofit.service.GenderizeService;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RetrofitApplicationTests {

	private WireMockServer wireMockServer;

	private GanderizeController ganderizeController;

	@BeforeEach
	void setUp() {
		wireMockServer = new WireMockServer();
		wireMockServer.start();
		WireMock.configureFor(wireMockServer.port());

		// Assuming you have a real implementation of GenderizeService
		GenderizeService genderizeService = new GenderizeService();
		ganderizeController = new GanderizeController(genderizeService);
	}

	@AfterEach
	void tearDown() {
		wireMockServer.stop();
	}

	@Test
	void testGetGender() throws IOException {
		// Given
		String name = "Yana";

		// When
		BaseResponse result = ganderizeController.getGender(name);

		// Then
		assertEquals(HttpStatus.OK.value(), result.getStatus(), "Status should be OK");
		assertEquals("Find All", result.getMessage(), "Message should be 'Find All'");
		// You might need to adjust this based on the actual structure of your GenderizeResponse class
		assertEquals("male", ((GenderizeResponse) result.getData()).getGender(), "Expected and actual gender should match");
	}
}
