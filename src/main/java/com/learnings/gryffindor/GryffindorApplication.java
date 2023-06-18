package com.learnings.gryffindor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GryffindorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GryffindorApplication.class, args);
	}

	@GetMapping("/health")
	ResponseEntity<Object> health() {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}


