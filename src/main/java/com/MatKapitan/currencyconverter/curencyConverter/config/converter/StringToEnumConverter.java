package com.MatKapitan.currencyconverter.curencyConverter.config.converter;


import com.MatKapitan.currencyconverter.curencyConverter.ECurrency;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Service;


@Service
public class StringToEnumConverter implements Converter<String, ECurrency> {


    @Override
    public ECurrency convert(String source) {
        // Remove the try-catch block if we want to handle the exception globally in GlobalControllerExceptionHandler
        try {
            return ECurrency.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("enum exception");
        }

    }
}


