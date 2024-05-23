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

    @GetMapping("/{sourceCurrency}/{sourceAmount}/{targetCurrency}")
    public ResponseEntity<BigDecimal> currencyConverter(@PathVariable ECurrency sourceCurrency,
                                                        @PathVariable BigDecimal sourceAmount,
                                                        @PathVariable ECurrency targetCurrency){
        BigDecimal convert = currencyConverterService.convert(sourceCurrency, sourceAmount, targetCurrency);
        return new ResponseEntity<>(convert, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<BigDecimal> currencyConverter(@RequestBody CurrencyConvertRequest currencyConvertRequest){
        CurrencyConvertRequest currency = currencyConvertRequest;
        //TODO refactor
        BigDecimal result = currencyConverterService.convert(currency.getSourceCurrency(), currency.getSourceAmount(), currency.getTargetCurrency());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/test")
    public void test(){
        currencyConverterService.test();
    }
}

