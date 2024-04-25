package com.example.provaAv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableMongoRepositories("com.example.provaAv1.repository")
public class ProvaAv1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProvaAv1Application.class, args);
	}

}
