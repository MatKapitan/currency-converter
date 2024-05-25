package com.MatKapitan.currencyconverter.curencyConverter;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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


    @GetMapping("/test")
    public void test(){
        currencyConverterService.test();
    }
}

