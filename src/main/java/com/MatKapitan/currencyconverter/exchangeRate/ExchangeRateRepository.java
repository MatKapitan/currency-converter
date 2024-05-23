package com.MatKapitan.currencyconverter.exchangeRate;

import com.MatKapitan.currencyconverter.curencyConverter.ECurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    @Query(value = """
            SELECT x.SREDNJI_TECAJ FROM EXCHANGE_RATE x
            WHERE VALUTA = ?;
            """, nativeQuery = true)
    String getExchangeRate(String currency);
}
