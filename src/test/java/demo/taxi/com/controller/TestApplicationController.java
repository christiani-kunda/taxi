package demo.taxi.com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import demo.taxi.com.model.Driver;
import demo.taxi.com.model.ETripState;
import demo.taxi.com.model.Trip;
import demo.taxi.com.util.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The Class TestApplicationController.
 *
 * @author Christian Iradukunda
 */
@Sql(scripts = "/data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/truncate.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestApplicationController {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	void getClosestDriversByRider() throws JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("riderId", "a631cf5f-9232-4a20-8cf4-3d140b1fcb8b");

		String responseString = this.restTemplate.exchange(this.getBaseUrl() + "/get-closed-drivers", HttpMethod.GET, new HttpEntity<>(headers), String.class).getBody();
		assert responseString != null;
		ObjectMapper mapper = new ObjectMapper();
		Response<List<Driver>> response = mapper.readValue(responseString, Response.class);
		assertThat(response.getStatus()).isTrue();
		assertThat(response.getData()).isNotNull();
		assertThat(response.getData().size()).isEqualTo(3);


	}


	@Test
	void createTrip() throws JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("driverId", "be919e4c-78c2-43ca-aac8-ab4663cba10a");
		headers.set("riderId", "afd1f854-8662-491b-abbf-6384f1fb0164");
		headers.set("destinationLocation", "23,54");

		String responseString = this.restTemplate.exchange(this.getBaseUrl() + "/create-trip", HttpMethod.POST, new HttpEntity<>(headers), String.class).getBody();
		assert responseString != null;
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(responseString);
		Map<String,Object> data = mapper.readValue(responseString, Map.class);

		Gson gson = new Gson();
		Trip trip = gson.fromJson(gson.toJson(data.get("data")),Trip.class);
		assertThat((Boolean) data.get("status")).isTrue();
		assertThat(data.get("data")).isNotNull();
		assertThat(trip).isNotNull();
		assertThat(trip.getId()).isNotNull();
		assertThat(trip.getState()).isEqualTo(ETripState.ACTIVE);

	}

	@Test
	void completeTrip() throws JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("tripId", "bf5e6ba4-93e1-4107-86fa-53c1212701d9");

		String responseString = this.restTemplate.exchange(this.getBaseUrl() + "/complete-trip", HttpMethod.PUT, new HttpEntity<>(headers), String.class).getBody();
		assert responseString != null;
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(responseString);
		Map<String,Object> data = mapper.readValue(responseString, Map.class);

		Gson gson = new Gson();
		Trip trip = gson.fromJson(gson.toJson(data.get("data")),Trip.class);
		assertThat((Boolean) data.get("status")).isTrue();
		assertThat(data.get("data")).isNotNull();
		assertThat(trip).isNotNull();
		assertThat(trip.getId()).isEqualTo(UUID.fromString("bf5e6ba4-93e1-4107-86fa-53c1212701d9"));
		assertThat(trip.getState()).isEqualTo(ETripState.COMPLETED);
	}

	private String getBaseUrl(){
		return "http://localhost:"+ port + "/request";
	}
}