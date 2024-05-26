//package com.MatKapitan.currencyconverter.curencyConverter.enumValidation;
//
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//import jakarta.validation.constraints.NotNull;
//
//import java.lang.annotation.*;
//
//@Documented
//@Target(ElementType.FIELD)
//@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = EnumValidatorConstraint.class)
//@NotNull
//public @interface EnumValidator {
//
//    Class<? extends Enum<?>> enum();
//    String message() default "must be any of enum {enum}";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
//}
