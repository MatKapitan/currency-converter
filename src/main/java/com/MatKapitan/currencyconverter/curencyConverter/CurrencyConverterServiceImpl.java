package com.MatKapitan.currencyconverter.curencyConverter;

import com.MatKapitan.currencyconverter.exchangeRate.ExchangeRateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class CurrencyConverterServiceImpl implements CurrencyConverterService {

    private final ExchangeRateRepository exchangeRateRepository;

    @Override
    public BigDecimal convert(ECurrency sourceCurrency, BigDecimal sourceAmount, ECurrency targetCurrency) {

        if (sourceCurrency != ECurrency.EUR){
            //to euro
        }
        if (targetCurrency != ECurrency.EUR){
            //to target
        }
        return null;
    }

    private BigDecimal convertToEuro(BigDecimal sourceAmount){
        //to euro
        return null;
    }

    private BigDecimal convertToTarget(BigDecimal sourceAmount, ECurrency targetCurrency){
        //to target
        return null;
    }

}
