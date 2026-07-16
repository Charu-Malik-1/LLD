package com.cricbuzz.pull_based;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CricbuzzApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricbuzzApplication.class, args);
		System.out.println("hi cricbuzz");
	}

}
