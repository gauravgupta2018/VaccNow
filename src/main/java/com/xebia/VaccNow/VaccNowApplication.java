package com.xebia.VaccNow;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaccNowApplication {

	public static void main(String[] args) {
		
		SpringApplication springApplicaton  = new SpringApplication(VaccNowApplication.class);
		springApplicaton.setDefaultProperties(Collections.singletonMap("spring.profiles.default", "local"));
		springApplicaton.run(args);
	
	}
}
