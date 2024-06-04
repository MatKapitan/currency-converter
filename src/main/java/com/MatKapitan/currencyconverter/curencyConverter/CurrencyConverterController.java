package com.MatKapitan.currencyconverter.curencyConverter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.EnumSet;

@RestController
@AllArgsConstructor
@RequestMapping("/currency-converter")
@Tag(name = "Currency converter")
public class CurrencyConverterController {
    
    private final CurrencyConverterService currencyConverterService;



    @Operation(description = "Returns target currency amount, if not provided target currency is EUR")
    @GetMapping("/")
    public ResponseEntity<BigDecimal> currencyConverter(@RequestParam(name = "sourceCurrency") ECurrency sourceCurrency,
                                                        @RequestParam(name = "sourceAmount") BigDecimal sourceAmount,
                                                        @RequestParam(name = "targetCurrency",defaultValue = "EUR", required = false) ECurrency targetCurrency){
        BigDecimal convert = currencyConverterService.convert(sourceCurrency, sourceAmount, targetCurrency);
        return new ResponseEntity<>(convert, HttpStatus.OK);
    }

    @Operation(description = "Returns list of all supported currencies")
    @GetMapping("/all")
    public ResponseEntity<EnumSet<ECurrency>> getAllCurrencies(){
        EnumSet<ECurrency> allCurrency = currencyConverterService.getAllCurrencies();
        return new ResponseEntity<>(allCurrency, HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> BadRequest(IllegalArgumentException ex) {
        return new ResponseEntity<>("Currency not supported", HttpStatus.BAD_REQUEST);
    }
}

