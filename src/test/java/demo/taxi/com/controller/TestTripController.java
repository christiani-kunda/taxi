package demo.taxi.com.controller;

import demo.taxi.com.model.Trip;
import demo.taxi.com.util.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The Class TestTripController.
 *
 * @author Christian Iradukunda
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestTripController {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void findAllTrips(){
		Response<List<Trip>> response = this.restTemplate.getForObject(this.getBaseUrl() + "/all-active-trips", Response.class);
		assertThat(response.getStatus()).isTrue();
		assertThat(response.getData().size()).isEqualTo(0);
	}

	@Sql(scripts = "/data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts = "/truncate.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	void findAllTripsSecond(){
		Response<List<Trip>> response = this.restTemplate.getForObject(this.getBaseUrl() + "/all-active-trips", Response.class);
		assertThat(response.getStatus()).isTrue();
		assertThat(response.getData().size()).isEqualTo(3);
	}
	
	private String getBaseUrl(){
		return "http://localhost:"+ port + "/trip";
	}
}