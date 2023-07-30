package com.nikhil.intuit.CraftDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.nikhil"})
public class CraftDemoApplication {

	public static void main(String[] args) {
		final Logger logger = LogManager.getLogger(CraftDemoApplication.class);

		SpringApplication.run(CraftDemoApplication.class, args);
		logger.info("Service up and running");
	}

}
