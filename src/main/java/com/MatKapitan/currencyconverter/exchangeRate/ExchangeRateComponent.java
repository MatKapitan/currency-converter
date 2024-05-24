package com.MatKapitan.currencyconverter.exchangeRate;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ExchangeRateComponent {

    private final ExchangeRateRepository exchangeRateRepository;

    @Value("${exchange.rate.url}")
    private String EXCHANGE_RATE_URL;

    @PostConstruct
    public void onStartup() {
        List<ExchangeRate> exchangeRates = this.getExchangeRates();
        exchangeRateRepository.saveAll(exchangeRates);
    }

    @Scheduled(cron = "@midnight")
    public void onSchedule() {
        List<ExchangeRate> newExchangeRates = this.getExchangeRates();
        List<ExchangeRate> existingExchangeRates= exchangeRateRepository.findAll();
        for (ExchangeRate x : existingExchangeRates){
            for (ExchangeRate y: newExchangeRates) {
                if (x.getValuta().equals(y.getValuta())){
                    x.setDatum_primjene(y.getDatum_primjene());
                    x.setKupovni_tecaj(y.getKupovni_tecaj());
                    x.setSrednji_tecaj(y.getSrednji_tecaj());
                    x.setProdajni_tecaj(y.getProdajni_tecaj());
                }
            }
        }
        exchangeRateRepository.saveAll(existingExchangeRates);
    }

//     for testing purpose
        @Scheduled(fixedRate = 10000, initialDelay = 30000)
    public void testing() {
        this.onSchedule();
    }

    private List<ExchangeRate> getExchangeRates(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ExchangeRate[]> response = restTemplate.getForEntity( EXCHANGE_RATE_URL, ExchangeRate[].class);
        ExchangeRate[] exchangeRates = response.getBody();
        if (exchangeRates == null) throw new RuntimeException("exchange rate can't be null");
        return Arrays.asList(exchangeRates);
    }

}
