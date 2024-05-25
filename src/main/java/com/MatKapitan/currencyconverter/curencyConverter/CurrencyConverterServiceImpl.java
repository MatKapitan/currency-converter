package com.MatKapitan.currencyconverter.curencyConverter;

import com.MatKapitan.currencyconverter.exchangeRate.ExchangeRateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@AllArgsConstructor
public class CurrencyConverterServiceImpl implements CurrencyConverterService {

    private final ExchangeRateRepository exchangeRateRepository;

    @Override
    public BigDecimal convert(ECurrency sourceCurrency, BigDecimal sourceAmount, ECurrency targetCurrency) {
        //TODO refactor?
        BigDecimal result = sourceAmount;

        if (sourceCurrency != ECurrency.EUR){
            //to euro
            result = convertToEuro(result, sourceCurrency);
        }
        if (targetCurrency != ECurrency.EUR){
            //to target
            result = convertToTarget(result, targetCurrency);
        }
        return result.setScale(2,RoundingMode.HALF_EVEN);
    }

    private BigDecimal convertToEuro(BigDecimal sourceAmount, ECurrency sourceCurrency){
        //to euro
        String exchangeRate = exchangeRateRepository.getExchangeRate(sourceCurrency.toString());
        BigDecimal bigDecimal = new BigDecimal(exchangeRate.replace(",","."));
        return sourceAmount.divide(bigDecimal,8, RoundingMode.HALF_EVEN);
    }

    private BigDecimal convertToTarget(BigDecimal sourceAmount, ECurrency targetCurrency){
        //to target
        String exchangeRate = exchangeRateRepository.getExchangeRate(targetCurrency.toString());
        BigDecimal bigDecimal = new BigDecimal(exchangeRate.replace(",","."));
        return sourceAmount.multiply(bigDecimal);
    }

    //TODO remove when no longer needed
    @Override
    public void test() {
        String s = exchangeRateRepository.getExchangeRate(ECurrency.DKK.toString());
        System.out.println(s);
        ECurrency eur = ECurrency.EUR;
    }
}
