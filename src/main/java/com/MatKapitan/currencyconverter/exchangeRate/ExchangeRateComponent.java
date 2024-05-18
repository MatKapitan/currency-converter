package com.MatKapitan.currencyconverter.exchangeRate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ExchangeRateComponent {

    @Value("${exchange.rate.url}")
    private String EXCHANGE_RATE_URL;

    public List<ExchangeRate> getExchangeRates(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ExchangeRate[]> response = restTemplate.getForEntity( EXCHANGE_RATE_URL, ExchangeRate[].class);
        ExchangeRate[] exchangeRates = response.getBody();
        System.out.println(Arrays.toString(exchangeRates));
        return null;
    }
}
