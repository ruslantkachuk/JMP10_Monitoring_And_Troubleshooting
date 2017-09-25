package com.jmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JmpApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(JmpApplication.class, args);
		Thread.currentThread().join();
	}
}
