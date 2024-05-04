package net.hotelapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelLocationApplication.class, args);
	}

}
