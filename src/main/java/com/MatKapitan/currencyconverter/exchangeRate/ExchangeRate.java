package com.MatKapitan.currencyconverter.exchangeRate;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "exchange_rate", indexes = {
        @Index(name = "idx_currency_valuta", columnList = "valuta")
})
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valuta", nullable = false)
    private String valuta;
    private String broj_tecajnice;
    private String datum_primjene;
    private String drzava;
    private String sifra_valute;
    private String kupovni_tecaj;
    private String srednji_tecaj;
    private String prodajni_tecaj;
}
