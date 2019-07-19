package pe.edu.tecsup.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@SpringBootApplication
@EnableJpaAuditing
public class ApiRestIntegrador2018IiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestIntegrador2018IiApplication.class, args);
	}
}
