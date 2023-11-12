package com.ian.monitorassets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class MonitorAssetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorAssetsApplication.class, args);
	}

}
