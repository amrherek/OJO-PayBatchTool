package com.atos.paybatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry

public class PayBatchToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayBatchToolApplication.class, args);
	}
}
