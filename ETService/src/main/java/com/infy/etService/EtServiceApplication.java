package com.infy.etService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = { "message.properties" })
public class EtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtServiceApplication.class, args);
	}

}
