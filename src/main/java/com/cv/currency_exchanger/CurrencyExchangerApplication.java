package com.cv.currency_exchanger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CurrencyExchangerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangerApplication.class, args);
	}

}
