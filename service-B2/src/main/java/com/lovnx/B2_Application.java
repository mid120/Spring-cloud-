package com.lovnx;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class B2_Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(B2_Application.class).web(true).run(args);
	}



	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
