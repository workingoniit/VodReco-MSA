package com.detail.UserActivityCUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.detail.UserActivityCUD.mongoRepository")
@EnableJpaRepositories(basePackages = "com.detail.UserActivityCUD.repository") // JpaRepository 패키지 위치 등록
public class UserActivityCudApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserActivityCudApplication.class, args);
	}

}
