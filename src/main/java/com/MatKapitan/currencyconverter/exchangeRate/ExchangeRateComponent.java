package com.MatKapitan.currencyconverter.exchangeRate;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ExchangeRateComponent {

    ExchangeRateRepository exchangeRateRepository;

    public ExchangeRateComponent(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Value("${exchange.rate.url}")
    private String EXCHANGE_RATE_URL;

    @PostConstruct
    public void onStartup() {
        this.getExchangeRates();
    }

    @Scheduled(cron = "@midnight")
    public void onSchedule() {
        exchangeRateRepository.deleteAll();
        this.getExchangeRates();
    }

    // for testing purpose
//        @Scheduled(fixedRate = 10000)
//    public void onSchedule() {
//        exchangeRateRepository.deleteAll();
//        this.getExchangeRates();
//    }

    public List<ExchangeRate> getExchangeRates(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ExchangeRate[]> response = restTemplate.getForEntity( EXCHANGE_RATE_URL, ExchangeRate[].class);
        ExchangeRate[] exchangeRates = response.getBody();
        for (ExchangeRate exchangeRate : exchangeRates) {
            exchangeRateRepository.save(exchangeRate);
        }
        return null;
    }

}
