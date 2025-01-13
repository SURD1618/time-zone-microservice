package com.time_zone.time_converter_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class TimeConverterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeConverterServiceApplication.class, args);
	}

}
