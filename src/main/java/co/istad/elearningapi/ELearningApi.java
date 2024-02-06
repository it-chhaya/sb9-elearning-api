package co.istad.elearningapi;

import co.istad.elearningapi.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ELearningApi {

	public static void main(String[] args) {
		SpringApplication.run(ELearningApi.class, args);
	}

}
