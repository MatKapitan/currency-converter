package com.MatKapitan.currencyconverter.curencyConverter;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CurrencyConverter {

    private String desiredCurrency;
    private String currentCurrency;
    private BigDecimal amount;
}
