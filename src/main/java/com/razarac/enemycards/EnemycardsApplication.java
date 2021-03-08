package com.razarac.enemycards;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableFeignClients
@SpringBootApplication
public class EnemyCardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnemyCardsApplication.class, args);
	}

}
