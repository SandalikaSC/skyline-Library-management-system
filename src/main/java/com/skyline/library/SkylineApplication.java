package com.skyline.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.skyline.library")
public class SkylineApplication {

	public static void main(String[] args) {



		SpringApplication.run(SkylineApplication.class, args);
	}

}
