package com.MatKapitan.currencyconverter.curencyConverter;

import java.math.BigDecimal;
import java.util.EnumSet;

public interface CurrencyConverterService {


    public BigDecimal convert(ECurrency x, BigDecimal y, ECurrency z);

    public EnumSet<ECurrency> getAllCurrencies();

    public void test();

}
