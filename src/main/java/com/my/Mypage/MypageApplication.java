package com.my.Mypage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.my.Mypage.mongoRepository")
public class MypageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MypageApplication.class, args);
	}

}
