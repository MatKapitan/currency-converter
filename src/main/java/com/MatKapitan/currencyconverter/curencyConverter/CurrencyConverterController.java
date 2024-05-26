package com.MatKapitan.currencyconverter.curencyConverter;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.EnumSet;

@RestController
@AllArgsConstructor
@RequestMapping("/currency-converter")
public class CurrencyConverterController {
    
    private final CurrencyConverterService currencyConverterService;



    @GetMapping("/")
    public ResponseEntity<BigDecimal> currencyConverter(@RequestParam(name = "sourceCurrency") ECurrency sourceCurrency,
                                                        @RequestParam(name = "sourceAmount") BigDecimal sourceAmount,
                                                        @RequestParam(name = "targetCurrency",defaultValue = "EUR", required = false) ECurrency targetCurrency){
        BigDecimal convert = currencyConverterService.convert(sourceCurrency, sourceAmount, targetCurrency);
        return new ResponseEntity<>(convert, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<EnumSet<ECurrency>> getAllCurrencies(){
        EnumSet<ECurrency> allCurrency = currencyConverterService.getAllCurrencies();
        return new ResponseEntity<>(allCurrency, HttpStatus.OK);
    }


    @GetMapping("/test")
    public void test(){
        currencyConverterService.test();
    }
}

