package co.istad.elearningapi;

import co.istad.elearningapi.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ELearningApi implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ELearningApi.class, args);
	}

	private final InstructorService instructorService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello from console");
		System.out.println(instructorService.findList("c"));
	}
}
