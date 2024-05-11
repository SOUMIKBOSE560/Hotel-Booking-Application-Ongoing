package net.hotelapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelDetailsApplication {
	public static void main(String[] args) {
		SpringApplication.run(HotelDetailsApplication.class, args);
	}

}
