//package com.MatKapitan.currencyconverter.curencyConverter.enumValidation;
//
//import com.MatKapitan.currencyconverter.curencyConverter.ECurrency;
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//
//import java.util.EnumSet;
//
//public class EnumValidatorConstraint implements ConstraintValidator<EnumValidator, String> {
//
//    EnumSet<ECurrency> eCurrencies;
//    @Override
//    public void initialize(EnumValidator constraintAnnotation) {
//        eCurrencies = EnumSet.allOf(ECurrency.class);
//        ConstraintValidator.super.initialize(constraintAnnotation);
//    }
//
//    @Override
//    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
//        return eCurrencies.contains(s);
//    }
//}
