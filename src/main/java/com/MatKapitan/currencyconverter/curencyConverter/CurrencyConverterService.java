package com.MatKapitan.currencyconverter.curencyConverter;

import java.math.BigDecimal;

public interface CurrencyConverterService {


    public BigDecimal convert(ECurrency x, BigDecimal y, ECurrency z);

    public void test();

}
