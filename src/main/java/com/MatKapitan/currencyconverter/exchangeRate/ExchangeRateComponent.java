package com.MatKapitan.currencyconverter.exchangeRate;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExchangeRateComponent {

    private final String EXCHANGE_RATE_URL = "https://api.hnb.hr/tecajn-eur/v3";

    public List<ExchangeRate> getExchangeRates(){
        //TODO
        return null;
    }
}
