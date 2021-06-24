package demo.taxi.com.controller;

import demo.taxi.com.model.Driver;
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

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The Class TestsDriverService.
 *
 * @author Christian Iradukunda
 */
@Sql(scripts = "/driver-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/driver-truncate.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestDriverController {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void findAllDrivers(){
		Response<List<Driver>> response = this.restTemplate.getForObject(this.getBaseUrl() + "/all", Response.class);
		assertThat(response.getStatus()).isTrue();
		assertThat(response.getData().size()).isEqualTo(10);
	}

	@Test
	void findDriverById(){
		HttpHeaders headers = new HttpHeaders();
		headers.set("driverId", "17b89c8f-330a-44b8-a566-b50dd4dda39f");

		Response<Driver> response = this.restTemplate.exchange(this.getBaseUrl() + "/id", HttpMethod.GET, new HttpEntity<>(headers), Response.class).getBody();
		assert response != null;
		assertThat(response.getStatus()).isTrue();
		assertThat(response.getData()).isNotNull();
	}
	@Test
	void findDriverByIdNegative(){
		HttpHeaders headers = new HttpHeaders();
		headers.set("driverId", "5340f119-6f29-458d-973e-8b98c5c6ccb5");
		Response<Driver> response = this.restTemplate.exchange(this.getBaseUrl() + "/id", HttpMethod.GET, new HttpEntity<>(headers), Response.class).getBody();
		assert response != null;
		assertThat(response.getStatus()).isFalse();
		assertThat(response.getData()).isNull();;
	}
	@Test
	void findAllAvailableDrivers(){
		Response<List<Driver>> response = this.restTemplate.getForObject(this.getBaseUrl() + "/all-active", Response.class);
		assertThat(response.getStatus()).isTrue();
		assertThat(response.getData().size()).isEqualTo(10);
	}
	@Test
	void findAllAvailableDriversByDistance(){
		HttpHeaders headers = new HttpHeaders();
		headers.set("distance", "20.0");
		headers.set("location", "23,54");

		Response<Driver> response = this.restTemplate.exchange(this.getBaseUrl() + "/all-active-by-distance", HttpMethod.GET, new HttpEntity<>(headers), Response.class).getBody();
		assert response != null;
		assertThat(response.getStatus()).isTrue();
		assertThat(response.getData()).isNotNull();
	}

	@Test
	void findAllAvailableDriversByDistanceNegative(){
		HttpHeaders headers = new HttpHeaders();
		headers.set("distance", "24.4");
		headers.set("location", "5340f119-6f29-458d-973e-8b98c5c6ccb5");
		Response<Driver> response = this.restTemplate.exchange(this.getBaseUrl() + "/all-active-by-distance", HttpMethod.GET, new HttpEntity<>(headers), Response.class).getBody();
		assert response != null;
		System.out.println(response.getData());
		System.out.println(response.getStatus());
		assertThat(response.getStatus()).isFalse();
		assertThat(response.getData()).isNull();;

	}

	private String getBaseUrl(){
		return "http://localhost:"+ port + "/driver";
	}

}