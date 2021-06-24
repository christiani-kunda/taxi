package demo.taxi.com.controller;

import demo.taxi.com.model.Driver;
import demo.taxi.com.model.Rider;
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
 * The Class TestsRiderService.
 *
 * @author Christian Iradukunda
 */
@Sql(scripts = "/data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/truncate.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestRiderController {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void findAllRiders(){
		Response<List<Rider>> response = this.restTemplate.getForObject(this.getBaseUrl() + "/all", Response.class);
		assertThat(response.getStatus()).isTrue();
		assertThat(response.getData().size()).isEqualTo(10);
	}

	@Test
	void findRiderById(){
		HttpHeaders headers = new HttpHeaders();
		headers.set("riderId", "f9f6ed5f-8ce5-4a52-b6ca-d39b39c061fe");

		Response<Rider>
				response = this.restTemplate.exchange(this.getBaseUrl() + "/id", HttpMethod.GET, new HttpEntity<>(headers), Response.class).getBody();
		assert response != null;
		assertThat(response.getStatus()).isTrue();
		assertThat(response.getData()).isNotNull();
	}

	@Test
	void findRiderByIdNegative(){
		HttpHeaders headers = new HttpHeaders();
		headers.set("riderId", "5340f119-6f29-458d-973e-8b98c5c6ccb5");
		Response<Driver> response = this.restTemplate.exchange(this.getBaseUrl() + "/id", HttpMethod.GET, new HttpEntity<>(headers), Response.class).getBody();
		assert response != null;
		assertThat(response.getStatus()).isFalse();
		assertThat(response.getData()).isNull();;
	}

	private String getBaseUrl(){
		return "http://localhost:"+ port + "/rider";
	}
}