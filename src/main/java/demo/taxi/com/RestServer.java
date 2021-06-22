package demo.taxi.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"demo.taxi.com"}, exclude = { MongoAutoConfiguration.class})
@EnableJpaRepositories(basePackages = {"demo.taxi.com"})
@EntityScan(basePackages = {"demo.taxi.com"})
public class RestServer extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RestServer.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RestServer.class);
	}
}
