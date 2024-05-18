package com.MatKapitan.currencyconverter.curencyConverter;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CurrencyConvertRequest {


    private ECurrency targetCurrency;
    private ECurrency sourceCurrency;
    private BigDecimal sourceAmount;
}
