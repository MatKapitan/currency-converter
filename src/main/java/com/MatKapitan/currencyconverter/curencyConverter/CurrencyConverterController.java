package com.MatKapitan.currencyconverter.curencyConverter;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class CurrencyConverterController {
    
    private final CurrencyConverterService currencyConverterService;

    @GetMapping
    public ResponseEntity<BigDecimal> currencyConverter(@RequestBody CurrencyConvertRequest currencyConvertRequest){
        BigDecimal converter = currencyConverterService.convert(currencyConvertRequest);
        return new ResponseEntity<>(converter, HttpStatus.OK);
    }
}

