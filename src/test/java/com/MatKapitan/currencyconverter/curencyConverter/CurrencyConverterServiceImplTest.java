package com.MatKapitan.currencyconverter.curencyConverter;

import com.MatKapitan.currencyconverter.exchangeRate.ExchangeRateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CurrencyConverterServiceImplTest {

    @Mock
    private ExchangeRateRepository exchangeRateRepository;

    @InjectMocks
    private CurrencyConverterServiceImpl currencyConverterService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void convert() {
    }

    @Test
    public void should_successfully_convert_two_currency_from_source_to_target(){
        when(exchangeRateRepository.getExchangeRate("USD")).thenReturn("1,085200");
        when(exchangeRateRepository.getExchangeRate("GBP")).thenReturn("0,853650");

        BigDecimal result = currencyConverterService.convert(ECurrency.USD, BigDecimal.ONE, ECurrency.GBP);

        assertEquals(new BigDecimal("0.79"), result);
    }

    @Test
    public void should_successfully_convert_one_currency_from_source_to_eur(){
        when(exchangeRateRepository.getExchangeRate("USD")).thenReturn("1,085200");

        BigDecimal result = currencyConverterService.convert(ECurrency.USD, BigDecimal.ONE, ECurrency.EUR);

        assertEquals(new BigDecimal("0.92"), result);
    }

    @Test
    public void should_successfully_convert_one_currency_from_eur_to_target(){
        when(exchangeRateRepository.getExchangeRate("USD")).thenReturn("1,085200");

        BigDecimal result = currencyConverterService.convert(ECurrency.EUR, BigDecimal.ONE, ECurrency.USD);

        assertEquals(new BigDecimal("1.09"), result);
    }

}