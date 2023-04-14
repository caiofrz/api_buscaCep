package com.api.buscacep.busca_cep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BuscaCepApplication {

	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(BuscaCepApplication.class, args);
	}

	public static void close(int code) {
		SpringApplication.exit(context, () -> code);
	}

}
