package com.main.MainPage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.main.MainPage.mongoRepository")
public class MainPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainPageApplication.class, args);
	}

}
