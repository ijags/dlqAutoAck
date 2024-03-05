package com.sample.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DlqAutoAckApplication {

	public static void main(String[] args) {
		SpringApplication.run(DlqAutoAckApplication.class, args);
	}

}
