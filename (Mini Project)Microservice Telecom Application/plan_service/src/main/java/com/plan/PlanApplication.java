package com.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanApplication.class, args);
	}

}
