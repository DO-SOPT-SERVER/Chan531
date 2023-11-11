package com.server.dosopt.thirdseminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ThirdseminarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdseminarApplication.class, args);
	}

}