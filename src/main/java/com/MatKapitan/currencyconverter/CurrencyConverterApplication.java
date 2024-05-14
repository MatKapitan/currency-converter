package com.MatKapitan.currencyconverter;

import com.MatKapitan.currencyconverter.exchangeRate.ExchangeRateComponent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyConverterApplication implements CommandLineRunner {

	private final ExchangeRateComponent exchangeRateComponent;

	public CurrencyConverterApplication(ExchangeRateComponent exchangeRateComponent) {
		this.exchangeRateComponent = exchangeRateComponent;
	}

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		exchangeRateComponent.getExchangeRates();
	}
}
