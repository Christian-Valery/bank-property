package com.evaluation.bankProperty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankPropertyApplication {
	private static final Logger LOGGER = LogManager.getLogger(BankPropertyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BankPropertyApplication.class, args);
		LOGGER.info("Démarrage de l'application bank property");
	}

}
