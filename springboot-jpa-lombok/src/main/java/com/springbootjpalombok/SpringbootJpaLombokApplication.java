package com.springbootjpalombok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootJpaLombokApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaLombokApplication.class, args);
	}

}
